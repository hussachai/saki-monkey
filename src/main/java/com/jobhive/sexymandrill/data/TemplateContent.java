package com.jobhive.sexymandrill.data;

import com.jobhive.sexymandrill.utils.Assert;

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

    public void setName(String name) {
        Assert.notNull(name, "name");
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        Assert.notNull(content, "content");
        this.content = content;
    }
}
