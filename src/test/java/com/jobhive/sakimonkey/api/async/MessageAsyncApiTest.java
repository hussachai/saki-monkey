package com.jobhive.sakimonkey.api.async;

import org.testng.annotations.Test;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.request.Message;
import com.jobhive.sakimonkey.data.response.MessageStatus;
import com.jobhive.sakimonkey.test.BaseAsyncApiTest;
import com.jobhive.sakimonkey.test.asserts.MessageApiAssert;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageAsyncApiTest extends BaseAsyncApiTest {
    
    private MessageAsyncApi api(){
        return client.api().messages();
    }
    
    @Test
    public void testSend(){
        Message message = MessageApiAssert.createMessage(client.getContext());
        wait(api().send(message, new TestCallback<MessageStatus[]>() {
            @Override
            public void willTest(Result<MessageStatus[]> result) {
                MessageApiAssert.assertMessageStatuses(result, 1);
            }
        }));
    }
}
