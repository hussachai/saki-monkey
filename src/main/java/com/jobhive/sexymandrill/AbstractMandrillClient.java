package com.jobhive.sexymandrill;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jobhive.sexymandrill.data.request.ApiParam;
import com.jobhive.sexymandrill.exception.IORuntimeException;
import com.typesafe.config.Config;

/**
 * 
 * @author Hussachai
 *
 */
public abstract class AbstractMandrillClient {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    protected MandrillContext context;
    
    protected Config config;
    
    public AbstractMandrillClient() {
        this(null, null);
    }
    
    public AbstractMandrillClient(MandrillContext context) {
        this.context = context;
        this.config = context.getConfig();
        init();
    }
    
    public AbstractMandrillClient(String apiKey, String configPath) {
        this.context = new MandrillContext(apiKey, configPath);
        this.config = this.context.getConfig();
        init();
    }
    
    public MandrillContext getContext() {
        return context;
    }
    
    abstract protected void init();
    
    abstract public void shutdown();
    
    protected String getApiKeyAsJson() {
        /* Don't bother serializer to do this simple job */
        return "{\"key\": \"" + context.getApiKey() + "\"}";
    }
    
    protected String getUserAgent(){
        return context.getMetadata().getName() + "/" 
                + context.getMetadata().getVersion(); 
    }
    
    protected String convertParamsToJson(Object params) {
        if(params == null){
            log.debug("JSON param of ApiParam : [apiKey]");
            return getApiKeyAsJson();
        }else if(params instanceof ApiParam){
            ((ApiParam)params).setKey(context.getApiKey());
        }
        String value = null;
        try {
            value = context.getObjectMapper().writeValueAsString(params);
            log.debug("JSON param of {} : {}", 
                    params.getClass().getSimpleName(), value);
        } catch (JsonProcessingException e) {
            throw new IORuntimeException(e);
        }
        return value;
    }
    
    protected HttpHost detectHttpProxy(){
        if(config.hasPath("httpClient.proxy.host")){
            String host = config.getString("httpClient.proxy.host");
            int port = config.getInt("httpClient.proxy.port");
            return new HttpHost(host, port);
        }
        List<Proxy> proxies = null;
        try {
            proxies = ProxySelector.getDefault().select(
                    new URI(MandrillContext.BASE_URL));
        } catch (URISyntaxException e) {/*never happens*/}
        if(proxies != null){
            for(Proxy proxy: proxies){
                InetSocketAddress addr = (InetSocketAddress) proxy.address();
                if(addr != null){
                    return new HttpHost(addr.getHostName(), addr.getPort());
                }
            }
        }
        return null;
    }
    
    /**
     * 
     * @return
     */
    protected HostnameVerifier createHostnameVerifier(){
        return new DefaultHostnameVerifier();
    }
    
    protected CredentialsProvider createDefaultCredentialsProvider(String host, int port){
        if(!config.hasPath("httpClient.proxy.username")){
            return null;
        }
        String username = config.getString("httpClient.proxy.username");
        String password = config.getString("httpClient.proxy.password");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(host, port),
                new UsernamePasswordCredentials(username, password));
        return credsProvider;
    }
    
    protected RequestConfig createDefaultRequestConfig(){
        Builder configBuilder = RequestConfig.custom();
        configBuilder.setSocketTimeout(config.getInt("httpClient.request.socketTimeout"));
        configBuilder.setConnectTimeout(config.getInt("httpClient.request.connectTimeout"));
        configBuilder.setConnectionRequestTimeout(
                config.getInt("httpClient.request.connectionRequestTimeout"));
        return configBuilder.build();
    }
    
}
