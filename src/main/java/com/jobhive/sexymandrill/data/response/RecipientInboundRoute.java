package com.jobhive.sexymandrill.data.response;

/**
 * the information for recipient in the message (usually one) that matched an inbound route
 * @author Hussachai
 *
 */
public class RecipientInboundRoute {
    
    /**
     * the email address of the matching recipient
     */
    private String email;
    
    /**
     * the mailbox route pattern that the recipient matched
     */
    private String pattern;
    
    /**
     * the webhook URL that the message was posted to
     */
    private String url;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
