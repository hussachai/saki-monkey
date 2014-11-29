package com.jobhive.sexymandrill.data.request;

import java.util.List;

import com.jobhive.sexymandrill.utils.Literal;

/**
 * 
 * @author Hussachai
 *
 */
public class TemplateParams extends ApiParam {
    
    /**
     * the name for the new template - must be unique
     */
    private String name;
    
    /**
     * a default sending address for emails sent using this template
     */
    private String fromEmail;
    
    /**
     * a default from name to be used
     */
    private String fromName;
    
    /**
     * a default subject line to be used
     */
    private String subject;
    
    /**
     * the HTML code for the template with mc:edit attributes for the editable elements
     */
    private String code;
    
    /**
     * a default text part to be used when sending with this template
     */
    private String text;
    
    /**
     * set to false to add a draft template without publishing
     */
    private Boolean publish;
    
    /**
     * an optional array of up to 10 labels to use for filtering templates
     */
    private List<String> labels;

    public String getName() {
        return name;
    }

    public TemplateParams setName(String name) {
        this.name = name;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public TemplateParams setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public TemplateParams setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public TemplateParams setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getCode() {
        return code;
    }

    public TemplateParams setCode(String code) {
        this.code = code;
        return this;
    }

    public String getText() {
        return text;
    }

    public TemplateParams setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getPublish() {
        return publish;
    }

    public TemplateParams setPublish(Boolean publish) {
        this.publish = publish;
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public TemplateParams setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }
    
    public TemplateParams setLabels(String... labels) {
        this.labels = Literal.list(labels);
        return this;
    }
    
}
