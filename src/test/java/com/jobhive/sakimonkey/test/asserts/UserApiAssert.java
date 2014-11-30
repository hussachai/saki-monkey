package com.jobhive.sakimonkey.test.asserts;

import org.junit.Assert;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.UserInfo;

public final class UserApiAssert extends BaseAssert{

    public static void assertPing(Result<String> result){
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isError());
        Assert.assertNull(result.getErrorInfo());
        Assert.assertEquals("PONG!", result.getObject());
    }
    
    public static void assertInfo(Result<UserInfo> result){
        UserInfo userInfo = result.getObject();
        Assert.assertNotNull(userInfo);
        Assert.assertNotNull(userInfo.getUsername());
        println("Username: " + userInfo.getUsername());
        println("Created At: "+userInfo.getCreatedAt());
        Assert.assertTrue(userInfo.getReputation() > 0);
        println(userInfo.getStats().keySet());//TODO: maybe we want strong type here
    }
    
    public static void assertSenders(Result<SenderInfo[]> result){
        SenderInfo senders[] = result.getObject();
        println(senders);
        Assert.assertNotNull(senders);
        if(senders.length > 0){
            Assert.assertNotNull(senders[0].getAddress());
            Assert.assertNotNull(senders[0].getCreatedAt());
        }
    }
}
