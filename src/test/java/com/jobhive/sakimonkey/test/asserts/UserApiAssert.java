package com.jobhive.sakimonkey.test.asserts;

import org.testng.Assert;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.UserInfo;

/**
 * 
 * @author Hussachai
 *
 */
public final class UserApiAssert extends BaseAssert{

    public static String assertPing(Result<String> result){
        assertResult(result);
        Assert.assertEquals("PONG!", result.getObject());
        return result.getObject();
    }
    
    public static UserInfo assertInfo(Result<UserInfo> result){
        assertResult(result);
        UserInfo userInfo = result.getObject();
        Assert.assertNotNull(userInfo.getUsername());
        println("Username: " + userInfo.getUsername());
        println("Created At: "+userInfo.getCreatedAt());
        Assert.assertTrue(userInfo.getReputation() > 0);
        println(userInfo.getStats().keySet());//TODO: maybe we want strong type here
        return userInfo;
    }
    
    public static SenderInfo[] assertSenders(Result<SenderInfo[]> result){
        assertResult(result);
        SenderInfo senders[] = result.getObject();
        Assert.assertNotNull(senders);
        if(senders.length > 0){
            Assert.assertNotNull(senders[0].getAddress());
            Assert.assertNotNull(senders[0].getCreatedAt());
        }
        return senders;
    }
}
