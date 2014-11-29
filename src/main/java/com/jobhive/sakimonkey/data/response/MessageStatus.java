package com.jobhive.sakimonkey.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageStatus {

    /**
     * the message's unique id
     */
    @JsonProperty("_id")
    private String id;

    /**
     * the email address of the recipient
     */
    private String email;

    /**
     * the sending status of the recipient - 
     * either "sent", "queued", "scheduled", "rejected", or "invalid"
     */
    private String status;

    /**
     * the reason for the rejection if the recipient status is "rejected" - 
     * one of "hard-bounce", "soft-bounce", "spam", "unsub", "custom", 
     * "invalid-sender", "invalid", "test-mode-limit", or "rule"
     */
    private String rejectReason;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getRejectReason() {
        return rejectReason;
    }
    
}
