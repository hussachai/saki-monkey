package com.jobhive.sakimonkey.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.jobhive.sakimonkey.MandrillAsyncClient;

public abstract class BaseAsyncApiTest extends BaseApiTest {
    
    protected static MandrillAsyncClient client;
    
    @BeforeClass
    public static void createClient(){
        client = new MandrillAsyncClient();
    }
    
    @AfterClass
    public static void shutdown(){
        client.shutdown();
    }
    
    /**
     * 
     * @param future
     */
    protected void wait(Future<HttpResponse> future){
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    
}
