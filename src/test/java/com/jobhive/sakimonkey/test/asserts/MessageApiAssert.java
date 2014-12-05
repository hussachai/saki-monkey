package com.jobhive.sakimonkey.test.asserts;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.MessageStatus;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageApiAssert extends BaseAssert {
    
    public static MessageStatus[] assertMessageStatuses(Result<MessageStatus[]> result){
        assertResult(result);
        MessageStatus statuses[] = result.getObject();
        return statuses;
    }
    
}
