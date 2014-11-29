package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sakimonkey.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class Template {
    
    /**
     * the immutable unique code name of the template
     */
    private String slug;
    
    /**
     * the name of the template
     */
    private String name;
    
    /**
     * the list of labels applied to the template
     */
    private String[] labels;
    
    /**
     * the full HTML code of the template, 
     * with mc:edit attributes marking the editable 
     * elements - draft version
     */
    private String code;
    
    /**
     * the subject line of the template, if provided - draft version
     */
    private String subject;
    
    /**
     * the default sender address for the template, if provided - draft version
     */
    private String fromEmail;
    
    /**
     * the default sender from name for the template, if provided - draft version
     */
    private String fromName;
    
    /**
     * the default text part of messages sent with the template, if provided - draft version
     */
    private String text;
    
    /**
     * the same as the template name - kept as a separate field for backwards compatibility
     */
    private String publishName;
    
    /**
     * the full HTML code of the template, with mc:edit attributes marking the editable 
     * elements that are available as published, if it has been published
     */
    private String publishCode;
    
    /**
     * the subject line of the template, if provided
     */
    private String publishSubject;
    
    /**
     * the default sender address for the template, if provided
     */
    private String publishFromEmail;
    
    /**
     * the default sender from name for the template, if provided
     */
    private String publishFromName;
    
    /**
     * the default text part of messages sent with the template, if provided
     */
    private String publishText;
    
    /**
     * the date and time the template was last published as 
     * a UTC string in YYYY-MM-DD HH:MM:SS format, or null 
     * if it has not been published
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date publishedAt;
    
    /**
     * the date and time the template was first created as 
     * a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * the date and time the template was last modified as 
     * a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date updatedAt;

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String[] getLabels() {
        return labels;
    }

    public String getCode() {
        return code;
    }

    public String getSubject() {
        return subject;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public String getText() {
        return text;
    }

    public String getPublishName() {
        return publishName;
    }

    public String getPublishCode() {
        return publishCode;
    }

    public String getPublishSubject() {
        return publishSubject;
    }

    public String getPublishFromEmail() {
        return publishFromEmail;
    }

    public String getPublishFromName() {
        return publishFromName;
    }

    public String getPublishText() {
        return publishText;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
