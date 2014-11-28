package com.jobhive.sexymandrill.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class EmailAddedStatus {
    
    private String email;
    
    private boolean added;

    public String getEmail() {
        return email;
    }

    public EmailAddedStatus setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isAdded() {
        return added;
    }

    public EmailAddedStatus setAdded(boolean added) {
        this.added = added;
        return this;
    }
    
}
