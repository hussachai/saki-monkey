package com.jobhive.sexymandrill.data.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.data.Attachment;
import com.jobhive.sexymandrill.data.Recipient;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageContent {
    
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
    private String fromEmail;
    
    /**
     * the alias of the sender (if any)
     */
    private String fromName;
    
    /**
     * the message's subject line
     */
    private String subject;
    
    /**
     * the message recipient's information
     */
    @JsonProperty("to")
    private Recipient recipient;
    
    /**
     * list of tags on this message
     */
    private String[] tags;
    
    /**
     * the key-value pairs of the custom MIME headers for the message's main document
     */
    private Map<String, String> headers;
    
    /**
     * the text part of the message, if any
     */
    private String text;
    
    /**
     * the HTML part of the message, if any
     */
    private String html;
    
    /**
     * an array of any attachments that can be found in the message
     */
    private Attachment[] attachments;

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

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachment[] attachments) {
        this.attachments = attachments;
    }
}
