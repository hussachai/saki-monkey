package com.jobhive.sakimonkey.data.response;

import java.util.Date;

/**
 * 
 * @author Hussachai
 *
 */
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getType() {
        return type;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public String getState() {
        return state;
    }

    public String getResultUrl() {
        return resultUrl;
    }
    
}
