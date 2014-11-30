package com.jobhive.sakimonkey.api;

import org.junit.Test;

import com.jobhive.sakimonkey.test.BaseSyncApiTest;
import com.jobhive.sakimonkey.test.asserts.UserApiAssert;

/**
 * 
 * @author Hussachai
 *
 */
public class UserApiTest extends BaseSyncApiTest {

    private UserApi api = client.api().users();
    
    @Test
    public void testPing(){
        UserApiAssert.assertPing(api.ping());
    }
    
    @Test
    public void testInfo(){
        UserApiAssert.assertInfo(api.info());
    }
    
    @Test
    public void testSenders(){
        UserApiAssert.assertSenders(api.senders());
    }
}
