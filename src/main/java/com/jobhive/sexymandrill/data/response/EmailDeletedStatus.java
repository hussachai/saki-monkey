package com.jobhive.sexymandrill.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class EmailDeletedStatus {
    
    private String email;
    
    private boolean deleted;

    public String getEmail() {
        return email;
    }

    public EmailDeletedStatus setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public EmailDeletedStatus setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
