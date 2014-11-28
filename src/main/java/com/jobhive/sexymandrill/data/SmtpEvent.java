package com.jobhive.sexymandrill.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * information about a specific smtp event
 * 
 * @author Hussachai
 *
 */
public class SmtpEvent {

    /**
     * the Unix timestamp when the event occured
     */
    @JsonProperty("ts")
    private long timestamp;
    
    /**
     * the message's state as a result of this event
     */
    private String type;
    
    /**
     * the SMTP response from the recipient's server
     */
    private String diag;

    public long getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public String getDiag() {
        return diag;
    }
    
}
