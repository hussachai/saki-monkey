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
    
    public Webhook setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Webhook setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Webhook setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthKey() {
        return authKey;
    }

    public Webhook setAuthKey(String authKey) {
        this.authKey = authKey;
        return this;
    }

    public List<MessageEvent> getEvents() {
        return events;
    }

    public Webhook setEvents(List<MessageEvent> events) {
        this.events = events;
        return this;
    }
    
    public Webhook setEvents(MessageEvent...events){
        this.events = Literal.list(events);
        return this;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public Webhook setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getLastSentAt() {
        return lastSentAt;
    }

    public Webhook setLastSentAt(Date lastSentAt) {
        this.lastSentAt = lastSentAt;
        return this;
    }

    public Integer getBatchesSent() {
        return batchesSent;
    }

    public Webhook setBatchesSent(Integer batchesSent) {
        this.batchesSent = batchesSent;
        return this;
    }

    public Integer getEventsSent() {
        return eventsSent;
    }

    public Webhook setEventsSent(Integer eventsSent) {
        this.eventsSent = eventsSent;
        return this;
    }

    public String getLastError() {
        return lastError;
    }

    public Webhook setLastError(String lastError) {
        this.lastError = lastError;
        return this;
    }
}
