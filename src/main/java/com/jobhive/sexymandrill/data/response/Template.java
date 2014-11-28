package com.jobhive.sexymandrill.data.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

public class Template {
    
    private String slug;
    
    private String name;
    
    private List<String> labels;
    
    private String code;
    
    private String subject;
    
    private String fromEmail;
    
    private String fromName;
    
    private String text;
    
    private String publishName;
    
    private String publishCode;
    
    private String publishSubject;
    
    private String publishFromEmail;
    
    private String publishFromName;
    
    private String publishText;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date publishedAt;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date updatedAt;

    public String getSlug() {
        return slug;
    }

    public Template setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getName() {
        return name;
    }

    public Template setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public Template setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Template setCode(String code) {
        this.code = code;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Template setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public Template setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public Template setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public String getText() {
        return text;
    }

    public Template setText(String text) {
        this.text = text;
        return this;
    }

    public String getPublishName() {
        return publishName;
    }

    public Template setPublishName(String publishName) {
        this.publishName = publishName;
        return this;
    }

    public String getPublishCode() {
        return publishCode;
    }

    public Template setPublishCode(String publishCode) {
        this.publishCode = publishCode;
        return this;
    }

    public String getPublishSubject() {
        return publishSubject;
    }

    public Template setPublishSubject(String publishSubject) {
        this.publishSubject = publishSubject;
        return this;
    }

    public String getPublishFromEmail() {
        return publishFromEmail;
    }

    public Template setPublishFromEmail(String publishFromEmail) {
        this.publishFromEmail = publishFromEmail;
        return this;
    }

    public String getPublishFromName() {
        return publishFromName;
    }

    public Template setPublishFromName(String publishFromName) {
        this.publishFromName = publishFromName;
        return this;
    }

    public String getPublishText() {
        return publishText;
    }

    public Template setPublishText(String publishText) {
        this.publishText = publishText;
        return this;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public Template setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Template setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Template setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
    
}
