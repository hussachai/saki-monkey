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
    private SendingStatus status;

    /**
     * the reason for the rejection if the recipient status is "rejected" - 
     * one of "hard-bounce", "soft-bounce", "spam", "unsub", "custom", 
     * "invalid-sender", "invalid", "test-mode-limit", or "rule"
     */
    private String rejectReason;

    @Override
    public String toString(){
        return email + " [" + status + "]";
    }
    
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public SendingStatus getStatus() {
        return status;
    }

    public String getRejectReason() {
        return rejectReason;
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static enum SendingStatus {
        SENT, QUEUED, SCHEDULED, REJECTED, INVALID;
        private String value;
        SendingStatus(){
            value = name().toLowerCase();
        }
        @Override
        public String toString(){
            return value;
        }
    }
}
