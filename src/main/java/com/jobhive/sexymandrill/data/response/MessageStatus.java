package com.jobhive.sexymandrill.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageStatus {

    @JsonProperty("_id")
    private String id;

    private String email;

    private String status;

    private String rejectReason;

    public String getId() {
        return id;
    }

    public MessageStatus setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MessageStatus setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public MessageStatus setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public MessageStatus setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
        return this;
    }
    
}
