package com.jobhive.sexymandrill.data.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.data.response.MessageContent.Recipient;

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

    public String getFromEmail() {
        return fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public Recipient[] getRecipients() {
        return recipients;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getText() {
        return text;
    }

    public String getHtml() {
        return html;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    public EmbeddedImage[] getImages() {
        return images;
    }

    /**
     * 
     * @author Hussachai
     *
     */
    public static class Attachment extends MessageContent.Attachment{
        
        /**
         * if this is set to true, the attachment is not pure-text, 
         * and the content will be base64 encoded
         */
        private Boolean binary;
        
        public Boolean getBinary() {
            return binary;
        }
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class EmbeddedImage extends MessageContent.Attachment{}
    
}
