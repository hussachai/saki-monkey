package com.jobhive.sexymandrill.data.param;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;
import com.jobhive.sexymandrill.data.MessageState;

/**
 * 
 * @author Hussachai
 *
 */
public class ExportActivityParams {
    
    /**
     * an optional email address to notify when the export job has finished
     */
    private String nofityEmail;
    
    /**
     * start date as a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date dateFrom;
    
    /**
     * end date as a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date dateTo;
    
    /**
     * an array of tag names to narrow the export to; will match messages that contain ANY of the tags
     */
    private Set<String> tags;
    
    /**
     * an array of senders to narrow the export to
     */
    private Set<String> senders;
    
    /**
     * an array of states to narrow the export to; messages with ANY of the states will be included
     */
    private Set<MessageState> states;
    
    /**
     * an array of api keys to narrow the export to; messsagse sent with ANY of the keys will be included
     */
    private Set<String> apiKeys;

    public String getNofityEmail() {
        return nofityEmail;
    }

    public ExportActivityParams setNofityEmail(String nofityEmail) {
        this.nofityEmail = nofityEmail;
        return this;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public ExportActivityParams setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public ExportActivityParams setDateTo(Date dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public Set<String> getTags() {
        return tags;
    }

    public ExportActivityParams setTags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public Set<String> getSenders() {
        return senders;
    }

    public ExportActivityParams setSenders(Set<String> senders) {
        this.senders = senders;
        return this;
    }

    public Set<MessageState> getStates() {
        return states;
    }

    public ExportActivityParams setStates(Set<MessageState> states) {
        this.states = states;
        return this;
    }

    public Set<String> getApiKeys() {
        return apiKeys;
    }

    public ExportActivityParams setApiKeys(Set<String> apiKeys) {
        this.apiKeys = apiKeys;
        return this;
    }
    
}
