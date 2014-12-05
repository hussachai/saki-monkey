package com.jobhive.sakimonkey.test.asserts;

import java.io.File;
import java.util.Date;

import org.testng.Assert;

import com.jobhive.sakimonkey.MandrillContext;
import com.jobhive.sakimonkey.api.MessageApiTest.Topic;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.request.Message;
import com.jobhive.sakimonkey.data.request.Message.EmbeddedImage;
import com.jobhive.sakimonkey.data.request.Message.Recipient;
import com.jobhive.sakimonkey.data.response.MessageStatus;
import com.typesafe.config.Config;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageApiAssert extends BaseAssert {
    
    public static Message createMessage(MandrillContext context){
        Config config = context.getConfig();
        Recipient rcp = new Recipient(config.getString("rcpt.email"), config.getString("rcpt.name"));
        rcp.addVar("title", "Saki-Monkey kisses Mandrill")
        .addVar("postedDate", new Date()).addVar("website", "http://www.jobhive.com")
        .addVar("header1", "Feeling productive even I sleep all day long.")
        .addVar("header2", "New banana flavor discovered by Saki-Monkey")
        .addVar("topics", new Topic[]{
                new Topic("Primate of the Old World"),
                new Topic("Who took my banana?"),
                new Topic("White face cosmatic.")});
        
        Message message = new Message()
        .setSubject("Message API Test")
        .setFromEmail(config.getString("from.email")).setFromName(config.getString("from.name"))
        .setHtml(new File("templates/minimalist/template.html"))
        .addRecipient(rcp)
        .addImage(new EmbeddedImage("envelope", "templates/minimalist/images/envelope.gif"));
        return message;
    }
    
    public static MessageStatus[] assertMessageStatuses(Result<MessageStatus[]> result, int expected){
        assertResult(result);
        MessageStatus statuses[] = result.getObject();
        Assert.assertEquals(expected, statuses.length);
        for(MessageStatus status: statuses){
            println(status);
            Assert.assertNotNull(status.getEmail());
        }
        return statuses;
    }
    
}
