package com.jobhive.sexymandrill.data.request;


/**
 * the injection of a single piece of content into a single editable region
 * 
 * @author Hussachai
 *
 */
public class TemplateContent {

    /**
     * the name of the mc:edit editable region to inject into
     */
    private String name;

    /**
     * the content to inject
     */
    private String content;

    public TemplateContent(String name, String content) {
        setName(name);
        setContent(content);
    }

    public String getName() {
        return name;
    }

    public TemplateContent setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TemplateContent setContent(String content) {
        this.content = content;
        return this;
    }
}
