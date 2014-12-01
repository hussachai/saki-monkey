package com.jobhive.sakimonkey.api.async;

import org.testng.annotations.Test;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.UserInfo;
import com.jobhive.sakimonkey.test.BaseAsyncApiTest;
import com.jobhive.sakimonkey.test.asserts.UserApiAssert;

/**
 * 
 * @author Hussachai
 *
 */
public class UserAsyncApiTest extends BaseAsyncApiTest {
    
    private UserAsyncApi api(){
        return client.api().users();
    }
    
    @Test
    public void testPing(){
        wait(api().ping(new TestCallback<String>() {
            @Override
            public void willTest(Result<String> result) {
                UserApiAssert.assertPing(result);
            }
        }));
    }
    
    @Test
    public void testInfo(){
        wait(api().info(new TestCallback<UserInfo>() {
            @Override
            public void willTest(Result<UserInfo> result) {
                UserApiAssert.assertInfo(result);
            }
        }));
    }
    
    @Test
    public void testSenders(){
        wait(api().senders(new TestCallback<SenderInfo[]>() {
            @Override
            public void willTest(Result<SenderInfo[]> result) {
                UserApiAssert.assertSenders(result);
            }
        }));
    }
}
