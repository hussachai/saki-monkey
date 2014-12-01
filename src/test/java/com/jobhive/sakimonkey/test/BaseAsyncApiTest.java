package com.jobhive.sakimonkey.test;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.Result;

/**
 * This base class serialize asynchronous operation. It changes 
 * execution order to deterministic. So, we can set and check state
 * before and after each test.
 * 
 * @author Hussachai
 *
 */
public abstract class BaseAsyncApiTest extends BaseApiTest {
    
    protected MandrillAsyncClient client;
    
    protected Throwable error;
    
    @BeforeMethod
    public void beforeTest(Method method){
        super.beforeTest(method);
        client = new MandrillAsyncClient();
        error = null;
    }
    
    @AfterMethod
    public void afterTest() throws Throwable{
        client.shutdown();
        if(error != null){
            throw error;
        }
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
    
    /**
     * 
     * @author Hussachai
     *
     * @param <T>
     */
    abstract protected class TestCallback<T> extends ObjectResponseCallback<T>{
        
        abstract public void willTest(Result<T> result);
        
        @Override
        public void onSuccess(Result<T> result) {
            try{
                willTest(result);  
            }catch(Throwable e){
                error = e;
            }
        }
    }
}
