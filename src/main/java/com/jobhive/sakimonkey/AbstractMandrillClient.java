package com.jobhive.sakimonkey;

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
import com.jobhive.sakimonkey.data.request.ApiParam;
import com.jobhive.sakimonkey.exception.IORuntimeException;
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
        if(config.getBoolean("httpClient.proxy.enabled")){
            log.info("Proxy is set");
            String host = config.getString("httpClient.proxy.host");
            int port = config.getInt("httpClient.proxy.port");
            log.info("Using proxy host='{}', port={}", host, port);
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
                    log.info("System detects proxy( host='{}', port={} )",
                            addr.getHostName(), addr.getPort());
                    return new HttpHost(addr.getHostName(), addr.getPort());
                }
            }
        }
        return null;
    }
    
    /**
     * 
     * @return default HostnameVerifier object
     */
    protected HostnameVerifier createHostnameVerifier(){
        return new DefaultHostnameVerifier();
    }
    
    protected CredentialsProvider createDefaultCredentialsProvider(String host, int port){
        if(!config.hasPath("httpClient.proxy.username")){
            return null;
        }
        log.info("Proxy authentication information is provided");
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
        int socketTimeout = config.getInt("httpClient.request.socketTimeout");
        int connTimeout = config.getInt("httpClient.request.connectTimeout");
        int connReqTimeout = config.getInt("httpClient.request.connectionRequestTimeout");
        log.info("Defeault request timeout: \n"
                + "\tsocketTimeout = {}\n"
                + "\tconnectionTimeout = {}\n"
                + "\tconnectionRequestTimeout = {}", 
                socketTimeout, connTimeout, connReqTimeout);
        configBuilder.setSocketTimeout(socketTimeout);
        configBuilder.setConnectTimeout(connTimeout);
        configBuilder.setConnectionRequestTimeout(connReqTimeout);
        return configBuilder.build();
    }
    
    protected ConnectionSettings createConnectionSettings(){
        ConnectionSettings s = new ConnectionSettings();
        s.shared = config.getBoolean("httpClient.connection.shared");
        s.defaultMaxPerRoute = config.getInt("httpClient.connection.defaultMaxPerRoute");
        s.maxTotal = config.getInt("httpClient.connection.maxTotal");
        log.info("Default connection settings: \n"
                + "\tshared = {}\n"
                + "\tdefaultMaxPerRoute = {}\n"
                + "\tmaxTotal = {}",
                s.shared, s.defaultMaxPerRoute, s.maxTotal);
        if(s.shared){
            log.info("!!! Connection Manager is set to shared !!!");
            log.info("Client is responsible for managing the connection"
                    + "and shutdown method has no effect on connection.");
        }
        return s;
    }
    
    protected class ConnectionSettings{
        boolean shared;
        int defaultMaxPerRoute;
        int maxTotal;
    }
    
    
}
