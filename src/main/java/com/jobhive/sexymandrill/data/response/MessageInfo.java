package com.jobhive.sexymandrill.data.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.data.ClickDetail;
import com.jobhive.sexymandrill.data.OpenDetail;
import com.jobhive.sexymandrill.data.RejectEvent;
import com.jobhive.sexymandrill.data.SmtpEvent;

public class MessageInfo {

    /**
     * the Unix timestamp from when this message was sent
     */
    @JsonProperty("ts")
    private long timestamp;

    /**
     * the message's unique id
     */
    @JsonProperty("_id")
    private String id;

    /**
     * the email address of the sender
     */
    private String sender;

    /**
     * the unique name of the template used, if any
     */
    private String template;

    /**
     * the message's subject line
     */
    private String subject;

    /**
     * the recipient email address
     */
    private String email;

    /**
     * list of tags on this message
     */
    private String[] tags;

    /**
     * how many times has this message been opened
     */
    private int opens;

    /**
     * list of individual opens for the message
     */
    @JsonProperty("opens_detail")
    private OpenDetail[] openDetails;

    /**
     * how many times has a link been clicked in this message
     */
    private int clicks;

    /**
     * list of individual clicks for the message
     */
    @JsonProperty("clicks_detail")
    private ClickDetail[] clickDetails;

    /**
     * sending status of this message: sent, bounced, rejected
     */
    private String state;

    /**
     * any custom metadata provided when the message was sent
     */
    private Map<String, String> metadata;

    private String bounceDescription;

    @JsonProperty("reject")
    private RejectEvent[] rejects;
    
    /**
     * a log of up to 3 smtp events for the message
     */
    private SmtpEvent[] smtpEvents;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int getOpens() {
        return opens;
    }

    public void setOpens(int opens) {
        this.opens = opens;
    }

    public OpenDetail[] getOpenDetails() {
        return openDetails;
    }

    public void setOpenDetails(OpenDetail[] openDetails) {
        this.openDetails = openDetails;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public ClickDetail[] getClickDetails() {
        return clickDetails;
    }

    public void setClickDetails(ClickDetail[] clickDetails) {
        this.clickDetails = clickDetails;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getBounceDescription() {
        return bounceDescription;
    }

    public void setBounceDescription(String bounceDescription) {
        this.bounceDescription = bounceDescription;
    }

    public RejectEvent[] getRejects() {
        return rejects;
    }

    public void setRejects(RejectEvent[] rejects) {
        this.rejects = rejects;
    }

    public SmtpEvent[] getSmtpEvents() {
        return smtpEvents;
    }

    public void setSmtpEvents(SmtpEvent[] smtpEvents) {
        this.smtpEvents = smtpEvents;
    }
    
}
