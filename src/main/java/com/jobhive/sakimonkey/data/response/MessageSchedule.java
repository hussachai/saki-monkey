package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sakimonkey.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageSchedule {
    
    /**
     * the scheduled message id
     */
    @JsonProperty("_id")
    private String id;
    
    /**
     * the UTC timestamp when the message was created, in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * the UTC timestamp when the message will be sent, in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date sendAt;
    
    /**
     * the email's sender address
     */
    private String fromEmail;
    
    /**
     * the email's recipient
     */
    @JsonProperty("to")
    private String toEmail;
    
    /**
     * the email's subject
     */
    private String subject;

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getSendAt() {
        return sendAt;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getSubject() {
        return subject;
    }
    
}
