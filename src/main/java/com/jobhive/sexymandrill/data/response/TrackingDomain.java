package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;
import com.jobhive.sexymandrill.data.DomainRecord;

/**
 * 
 * @author Hussachai
 *
 */
public class TrackingDomain {
    
    /**
     * the tracking domain name
     */
    private String domain;
    
    /**
     * the date and time that the tracking domain 
     * was added as a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * when the domain's DNS settings were last tested as a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date lastTestedAt;
    
    /**
     * details about the domain's CNAME record
     */
    private DomainRecord cname;
    
    /**
     * whether this domain can be used as a tracking domain for email.
     */
    private Boolean validTracking;

    public String getDomain() {
        return domain;
    }

    public TrackingDomain setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public TrackingDomain setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getLastTestedAt() {
        return lastTestedAt;
    }

    public TrackingDomain setLastTestedAt(Date lastTestedAt) {
        this.lastTestedAt = lastTestedAt;
        return this;
    }

    public DomainRecord getCname() {
        return cname;
    }

    public TrackingDomain setCname(DomainRecord cname) {
        this.cname = cname;
        return this;
    }

    public Boolean getValidTracking() {
        return validTracking;
    }

    public TrackingDomain setValidTracking(Boolean validTracking) {
        this.validTracking = validTracking;
        return this;
    }
    
}
