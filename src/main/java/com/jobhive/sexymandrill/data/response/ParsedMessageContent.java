package com.jobhive.sexymandrill.data.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.data.Attachment;
import com.jobhive.sexymandrill.data.EmbeddedImage;
import com.jobhive.sexymandrill.data.Recipient;

/**
 * 
 * @author Hussachai
 *
 */
public class ParsedMessageContent {

    /**
     * the subject of the message
     */
    private String subject;
    
    /**
     * the email address of the sender
     */
    private String fromEmail;
    
    /**
     * the alias of the sender (if any)
     */
    private String fromName;
    
    @JsonProperty("to")
    private Recipient[] recipients;
    
    /**
     * the key-value pairs of the MIME headers for the message's main document
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
    
    /**
     * an array of any embedded images that can be found in the message
     */
    private EmbeddedImage[] images;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public Recipient[] getRecipients() {
        return recipients;
    }

    public void setRecipients(Recipient[] recipients) {
        this.recipients = recipients;
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

    public EmbeddedImage[] getImages() {
        return images;
    }

    public void setImages(EmbeddedImage[] images) {
        this.images = images;
    }
    
}
