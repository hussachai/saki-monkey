package com.jobhive.sakimonkey.api;

import org.testng.annotations.Test;

import com.jobhive.sakimonkey.data.request.Message;
import com.jobhive.sakimonkey.test.BaseSyncApiTest;
import com.jobhive.sakimonkey.test.asserts.MessageApiAssert;

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
    public void testSend(){
        Message message = MessageApiAssert.createMessage(client.getContext());
        MessageApiAssert.assertMessageStatuses(api.send(message), 1);
    }
    
    @Test
    public void testSendTemplate(){
        Message message = MessageApiAssert.createMessage(client.getContext());
        MessageApiAssert.assertError(api.sendTemplate("does not exist", message));
    }
    
    
}
