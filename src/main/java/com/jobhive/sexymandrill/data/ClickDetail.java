package com.jobhive.sexymandrill.data;

/**
 * 
 * @author Hussachai
 *
 */
public class ClickDetail extends OpenDetail {

    /**
     * the URL that was clicked on
     */
    private String url;

    public String getUrl() {
        return url;
    }
    
    public ClickDetail setUrl(String url) {
        this.url = url;
        return this;
    }

}
