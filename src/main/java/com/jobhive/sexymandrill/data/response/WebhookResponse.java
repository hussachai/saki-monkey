package com.jobhive.sexymandrill.data.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;
import com.jobhive.sexymandrill.data.MessageEvent;
import com.jobhive.sexymandrill.utils.Literal;

/**
 * 
 * @author Hussachai
 *
 */
public class WebhookResponse {
    
    /**
     * a unique integer indentifier for the webhook
     */
    private int id;
    
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
    private List<MessageEvent> events;
    
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
    private int batchesSent;
    
    /**
     * the total number of events that have ever been sent to this webhook
     */
    private int eventsSent;
    
    /**
     * if we've ever gotten an error trying to post to this webhook, 
     * the last error that we've seen
     */
    private String lastError;

    public int getId() {
        return id;
    }
    
    public WebhookResponse setId(int id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public WebhookResponse setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WebhookResponse setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthKey() {
        return authKey;
    }

    public WebhookResponse setAuthKey(String authKey) {
        this.authKey = authKey;
        return this;
    }

    public List<MessageEvent> getEvents() {
        return events;
    }

    public WebhookResponse setEvents(List<MessageEvent> events) {
        this.events = events;
        return this;
    }
    
    public WebhookResponse setEvents(MessageEvent...events){
        this.events = Literal.list(events);
        return this;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public WebhookResponse setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getLastSentAt() {
        return lastSentAt;
    }

    public WebhookResponse setLastSentAt(Date lastSentAt) {
        this.lastSentAt = lastSentAt;
        return this;
    }

    public int getBatchesSent() {
        return batchesSent;
    }

    public WebhookResponse setBatchesSent(int batchesSent) {
        this.batchesSent = batchesSent;
        return this;
    }

    public int getEventsSent() {
        return eventsSent;
    }

    public WebhookResponse setEventsSent(int eventsSent) {
        this.eventsSent = eventsSent;
        return this;
    }

    public String getLastError() {
        return lastError;
    }

    public WebhookResponse setLastError(String lastError) {
        this.lastError = lastError;
        return this;
    }
}
