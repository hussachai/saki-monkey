package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sakimonkey.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class WhitelistEntry {
    
    /**
     * the email that is whitelisted
     */
    private String email;
    
    /**
     * a description of why the email was whitelisted
     */
    private String detail;
    
    /**
     * when the email was added to the whitelist
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;

    public String getEmail() {
        return email;
    }

    public String getDetail() {
        return detail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
}
