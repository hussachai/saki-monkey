package com.jobhive.sexymandrill.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class DomainStatus {
    
    public static enum Status {
        SENT, ALREADY_VERIFIED;
        
        @Override
        public String toString(){
            return name().toLowerCase();
        }
    }
    
    /**
     * "sent" indicates that the verification has been sent, 
     * "already_verified" indicates that the domain has already 
     * been verified with your account
     */
    private Status status;
    
    /**
     * the domain name you provided
     */
    private String domain;
    
    /**
     * the email address the verification email was sent to
     */
    private String email;

    public Status getStatus() {
        return status;
    }

    public DomainStatus setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public DomainStatus setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DomainStatus setEmail(String email) {
        this.email = email;
        return this;
    }
}
