package com.jobhive.sakimonkey;

import java.io.IOException;
import java.util.concurrent.Future;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.entity.NStringEntity;

import com.jobhive.sakimonkey.api.async.callback.JsonHttpFutureCallback;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;

/**
 * 
 * @author Hussachai
 *
 */
public class MandrillAsyncClient extends AbstractMandrillClient{
    
    private CloseableHttpAsyncClient httpAsyncClient;

    private AsyncApiCollections apiCollections;
    
    public MandrillAsyncClient() {}
    
    public MandrillAsyncClient(MandrillContext context) {
        super(context);
    }
    
    public MandrillAsyncClient(String apiKey, String configPath) {
        super(apiKey, configPath);
    }
    
    /**
     * 
     * @return
     */
    public AsyncApiCollections api() {
        return apiCollections;
    }
    
    /**
     * 
     * @param path
     * @param params
     * @param futureCallback
     * @return
     */
    public Future<HttpResponse> execute(String path, Object params,
            FutureCallback<HttpResponse> futureCallback) {
        HttpPost post = new HttpPost(getContext().getApiUrl(path));
        String data = convertParamsToJson(params);
        NStringEntity entity = new NStringEntity(data, ContentType.APPLICATION_JSON);
        post.setEntity(entity);
        Future<HttpResponse> future = httpAsyncClient.execute(post,
                futureCallback);
        return future;
    }

    /**
     * 
     * @param path
     * @param params
     * @param callback
     * @return
     */
    public Future<HttpResponse> execute(String path, Object params,
            ObjectResponseCallback<?> callback) {
        return execute(path, params, new JsonHttpFutureCallback(
                getContext().getObjectMapper(), callback));
    }
    
    @Override
    protected void init(){
        this.httpAsyncClient = createHttpAsyncClient();
        this.httpAsyncClient.start();
        this.apiCollections = new AsyncApiCollections(this);
    }
    
    @Override
    public void shutdown() {
        try {
            this.httpAsyncClient.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    /**
     * Factory method for Apache HttpAsyncClient
     * @return
     */
    protected CloseableHttpAsyncClient createHttpAsyncClient() {
        
        HttpAsyncClientBuilder clientBuilder = HttpAsyncClients.custom();
        clientBuilder.setSSLStrategy(createSchemeIOSessionStrategy());
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
    
    /**
     * 
     * @return
     */
    protected SchemeIOSessionStrategy createSchemeIOSessionStrategy(){
        
        return new SSLIOSessionStrategy(
                SSLContexts.createDefault(), createHostnameVerifier());
    }
}
