package com.jobhive.sakimonkey.api;

import java.io.IOException;

import org.testng.annotations.Test;

import com.jobhive.sakimonkey.data.request.Message;
import com.jobhive.sakimonkey.test.BaseSyncApiTest;
import com.jobhive.sakimonkey.test.asserts.MessageApiAssert;
import com.jobhive.sakimonkey.test.data.Messages;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageApiTest extends BaseSyncApiTest {
    
    private MessageApi api = client.api().messages();
    
    public static class Topic {
        protected String name;
        public Topic(){}
        public Topic(String name){
            this.name = name;
        }
    }
    
    @Test
    public void testSend() throws IOException{
        
        Message message = Messages.create();
        MessageApiAssert.assertMessageStatuses(api.send(message));
    }
}
