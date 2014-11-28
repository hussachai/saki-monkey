package com.jobhive.sexymandrill;

import java.io.IOException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.entity.NStringEntity;

import com.jobhive.sexymandrill.api.async.callback.JsonHttpFutureCallback;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;

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
    
    public AsyncApiCollections api() {
        return apiCollections;
    }
    
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
    
    protected CloseableHttpAsyncClient createHttpAsyncClient() {

        SSLIOSessionStrategy sslSessionStrategy = new SSLIOSessionStrategy(
                SSLContexts.createDefault(), new DefaultHostnameVerifier());
        return HttpAsyncClients.custom().setSSLStrategy(sslSessionStrategy)
                .build();
    }
    
}
