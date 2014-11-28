package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.Defaults;

public class ScheduledInfo {
    
    @JsonProperty("_id")
    private String id;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date sendAt;
    
    private String fromEmail;
    
    @JsonProperty("to")
    private String toEmail;
    
    private String subject;

    public String getId() {
        return id;
    }

    public ScheduledInfo setId(String id) {
        this.id = id;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public ScheduledInfo setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getSendAt() {
        return sendAt;
    }

    public ScheduledInfo setSendAt(Date sendAt) {
        this.sendAt = sendAt;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public ScheduledInfo setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getToEmail() {
        return toEmail;
    }

    public ScheduledInfo setToEmail(String toEmail) {
        this.toEmail = toEmail;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ScheduledInfo setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    
}
