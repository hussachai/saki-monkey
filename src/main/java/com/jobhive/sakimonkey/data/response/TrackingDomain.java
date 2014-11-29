package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sakimonkey.Defaults;
import com.jobhive.sakimonkey.data.response.Domain.DomainRecord;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastTestedAt() {
        return lastTestedAt;
    }

    public DomainRecord getCname() {
        return cname;
    }

    public Boolean getValidTracking() {
        return validTracking;
    }
}
