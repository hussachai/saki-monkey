package com.jobhive.sexymandrill.data.response;

public class InboundRoute {
    
    /**
     * the unique identifier of the route
     */
    private String id;
    
    /**
     * the search pattern that the mailbox name should match
     */
    private String pattern;
    
    /**
     * the webhook URL where inbound messages will be published
     */
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
