package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sakimonkey.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class Webhook {
    
    /**
     * a unique integer indentifier for the webhook
     */
    private Integer id;
    
    /**
     * The URL that the event data will be posted to
     */
    private String url;
    
    /**
     * a description of the webhook
     */
    private String description;
    
    /**
     * the key used to requests for this webhook
     */
    private String authKey;
    
    /**
     * The message events that will be posted to the hook
     */
    private MessageEvent[] events;
    
    /**
     * the date and time that the webhook was created as a UTC string 
     * in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * the date and time that the webhook last successfully received 
     * events as a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date lastSentAt;
    
    /**
     * the number of event batches that have ever been sent to this webhook
     */
    private Integer batchesSent;
    
    /**
     * the total number of events that have ever been sent to this webhook
     */
    private Integer eventsSent;
    
    /**
     * if we've ever gotten an error trying to post to this webhook, 
     * the last error that we've seen
     */
    private String lastError;
    
    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthKey() {
        return authKey;
    }

    public MessageEvent[] getEvents() {
        return events;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastSentAt() {
        return lastSentAt;
    }

    public Integer getBatchesSent() {
        return batchesSent;
    }

    public Integer getEventsSent() {
        return eventsSent;
    }

    public String getLastError() {
        return lastError;
    }

    /**
     * the individual message event
     * 
     * This enum is used in webhook.
     * 
     * @author Hussachai
     *
     */
    public enum MessageEvent {
        SEND, HARD_BOUNCE, SOFT_BOUNCE, OPEN, CLICK, SPAM, UNSUB, REJECT;
        
        private String value;
        
        MessageEvent(){
            this.value = name().toLowerCase();
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
}
