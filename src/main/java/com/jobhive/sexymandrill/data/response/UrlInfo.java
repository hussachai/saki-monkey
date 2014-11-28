package com.jobhive.sexymandrill.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class UrlInfo {
    
    /**
     * the URL to be tracked
     */
    private String url;
    
    /**
     * the number of emails that contained the URL
     */
    private int sent;
    
    /**
     * the number of times the URL has been clicked from a tracked email
     */
    private int clicks;
    
    /**
     * the number of unique emails that have generated clicks for this URL
     */
    private int uniqueClicks;

    public String getUrl() {
        return url;
    }

    public UrlInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getSent() {
        return sent;
    }

    public UrlInfo setSent(int sent) {
        this.sent = sent;
        return this;
    }

    public int getClicks() {
        return clicks;
    }

    public UrlInfo setClicks(int clicks) {
        this.clicks = clicks;
        return this;
    }

    public int getUniqueClicks() {
        return uniqueClicks;
    }

    public UrlInfo setUniqueClicks(int uniqueClicks) {
        this.uniqueClicks = uniqueClicks;
        return this;
    }
}
