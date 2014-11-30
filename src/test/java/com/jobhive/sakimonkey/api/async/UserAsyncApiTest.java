package com.jobhive.sakimonkey.api.async;

import org.junit.Test;

import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.UserInfo;
import com.jobhive.sakimonkey.test.BaseAsyncApiTest;
import com.jobhive.sakimonkey.test.asserts.UserApiAssert;

public class UserAsyncApiTest extends BaseAsyncApiTest {

    private UserAsyncApi api = client.api().users();
    
    @Test
    public void testPing(){
        wait(api.ping(new ObjectResponseCallback<String>() {
            @Override
            public void onSuccess(Result<String> result) {
                UserApiAssert.assertPing(result);
            }
        }));
    }
    
    @Test
    public void testInfo(){
        wait(api.info(new ObjectResponseCallback<UserInfo>() {
            @Override
            public void onSuccess(Result<UserInfo> result) {
                UserApiAssert.assertInfo(result);
            }
        }));
    }
    
    @Test
    public void testSenders(){
        wait(api.senders(new ObjectResponseCallback<SenderInfo[]>() {
            @Override
            public void onSuccess(Result<SenderInfo[]> result) {
                UserApiAssert.assertSenders(result);
            }
        }));
    }
}
