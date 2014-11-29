package com.jobhive.sexymandrill.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class RenderedTemplate {

    /**
     * the result of rendering the given template with the content 
     * and merge field values injected
     */
    private String html;

    @Override
    public String toString(){
        return html;
    }
    
    public String getHtml() {
        return html;
    }
    
}
