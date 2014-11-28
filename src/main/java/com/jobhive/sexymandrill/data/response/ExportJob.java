package com.jobhive.sexymandrill.data.response;

import java.util.Date;

public class ExportJob {
    
    /**
     * the unique identifier for this Export. 
     * Use this identifier when checking the export job's status
     */
    private String id;
    
    /**
     * the date and time that the export job was created as 
     * a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    private Date createdAt;
    
    /**
     * the type of the export job
     */
    private String type;
    
    /**
     * the date and time that the export job was finished as a UTC string in 
     * YYYY-MM-DD HH:MM:SS format, or null for jobs that have not run
     */
    private Date finishedAt;
    
    /**
     * the export job's state
     */
    private String state;
    
    /**
     * the url for the export job's results, if the job is complete
     */
    private String resultUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }
    
}
