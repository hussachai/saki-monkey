package com.jobhive.sakimonkey.test.data;

import java.io.File;
import java.util.Date;

import com.jobhive.sakimonkey.api.MessageApiTest.Topic;
import com.jobhive.sakimonkey.data.request.Message;
import com.jobhive.sakimonkey.data.request.Message.EmbeddedImage;
import com.jobhive.sakimonkey.data.request.Message.Recipient;

public class Messages {
    
    public static Message create(){
        Recipient rcp = new Recipient("hussachai@jobhive.com", "Hussachai Puripunpinyo");
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
        .setFromEmail("no-reply@jobhive.com").setFromName("JobHive")
        .setHtml(new File("templates/minimalist/template.html"))
        .addRecipient(rcp)
        .addImage(new EmbeddedImage("envelope", "templates/minimalist/images/envelope.gif"));
        return message;
    }
}
