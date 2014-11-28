package com.jobhive.sexymandrill.data.response;

import java.util.Date;

/**
 * 
 * @author Hussachai
 *
 */
public class InboundDomain {

    /**
     * the domain name that is accepting mail
     */
    private String domain;
    
    /**
     * the date and time that the inbound domain was added as 
     * a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    private Date createdAt;
    
    /**
     * true if this inbound domain has successfully set up an 
     * MX record to deliver mail to the Mandrill servers
     */
    private Boolean validMx;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getValidMx() {
        return validMx;
    }

    public void setValidMx(Boolean validMx) {
        this.validMx = validMx;
    }
    
}
