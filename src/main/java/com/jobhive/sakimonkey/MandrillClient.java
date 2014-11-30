package com.jobhive.sakimonkey;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpHost;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.nio.entity.NStringEntity;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.ErrorInfo;
import com.jobhive.sakimonkey.exception.IORuntimeException;

/**
 * 
 * @author Hussachai
 *
 */
public class MandrillClient extends AbstractMandrillClient {
    
    private CloseableHttpClient httpClient;
    
    private ApiCollections apiCollections;
    
    public MandrillClient(){}
    
    public MandrillClient(MandrillContext context) {
        super(context);
    }
    
    public MandrillClient(String apiKey, String configPath){
        super(apiKey, configPath);
    }
    
    /**
     * 
     * @return
     */
    public ApiCollections api() {
        return apiCollections;
    }
    
    /**
     * 
     * @param targetClass
     * @param path
     * @param params
     * @return
     */
    public <T>Result<T> execute(Class<T> targetClass,
            String path, Object params) {
        HttpPost post = new HttpPost(getContext().getApiUrl(path));
        String data = convertParamsToJson(params);
        NStringEntity entity = new NStringEntity(data, ContentType.APPLICATION_JSON);
        post.setEntity(entity);
        
        Result<T> result = null;
        
        try (CloseableHttpResponse response = httpClient.execute(post)) {
            InputStream in = response.getEntity().getContent();
            
            if (response.getStatusLine().getStatusCode() == 200) {
                result = new Result<>(context.getObjectMapper()
                        .readValue(in, targetClass));
            } else {
                result = new Result<>(context.getObjectMapper()
                        .readValue(in, ErrorInfo.class));
            }
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
        
        return result;
    }
    
    @Override
    protected void init() {
        this.httpClient = createHttpClient();
        this.apiCollections = new ApiCollections(this);
    }
    
    @Override
    public void shutdown() {
       try {
           httpClient.close();
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }
    
    protected CloseableHttpClient createHttpClient(){
        
        log.info("Creating HttpClient");
        
        HttpClientBuilder clientBuilder = HttpClients.custom();
        clientBuilder.setSSLSocketFactory(createSSLConnectionSocketFactory());
        
        ConnectionSettings connSettings = createConnectionSettings();
        clientBuilder.setConnectionManagerShared(connSettings.shared);
        clientBuilder.setMaxConnPerRoute(connSettings.defaultMaxPerRoute);
        clientBuilder.setMaxConnTotal(connSettings.maxTotal);
        
        HttpClientConnectionManager connectionManager = createConnectionManager();
        if(connectionManager != null){
            log.info("Connection manager is set");
            clientBuilder.setConnectionManager(connectionManager);
        }
        
        HttpHost proxy = detectHttpProxy();
        if(proxy != null){
            
            clientBuilder.setProxy(proxy);
            
            CredentialsProvider credsProvider = createDefaultCredentialsProvider(
                    proxy.getHostName(), proxy.getPort());
            if(credsProvider != null){
                clientBuilder.setDefaultCredentialsProvider(credsProvider);
            }
        }
        String userAgent = getUserAgent();
        log.debug("User-Agent: {}", userAgent);
        clientBuilder.setUserAgent(userAgent);
        clientBuilder.setDefaultRequestConfig(createDefaultRequestConfig());
        return clientBuilder.build();
    }
    
    protected HttpClientConnectionManager createConnectionManager(){
        return null;
    }
    
    protected SSLConnectionSocketFactory createSSLConnectionSocketFactory() {
        try {
            SSLContextBuilder sslContextBuilder = new SSLContextBuilder()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy());
            return new SSLConnectionSocketFactory(
                    sslContextBuilder.build(), createHostnameVerifier());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
