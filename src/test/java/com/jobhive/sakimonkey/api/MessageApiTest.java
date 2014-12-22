package com.jobhive.sakimonkey.api;

import org.testng.annotations.Test;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.request.Message;
import com.jobhive.sakimonkey.data.request.MessageSearchParams;
import com.jobhive.sakimonkey.data.response.MessageInfo;
import com.jobhive.sakimonkey.test.BaseSyncApiTest;
import com.jobhive.sakimonkey.test.asserts.MessageApiAssert;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageApiTest extends BaseSyncApiTest {
    
    private MessageApi api = client.api().messages();
    
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
    
    @Test(dependsOnMethods="testSend")
    public void testSearch(){
        Result<MessageInfo[]> result = api.search(
            new MessageSearchParams().setTags("test").setLimit(3));
        MessageApiAssert.assertMessageInfos(result);
    }
}
