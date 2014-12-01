package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sakimonkey.Defaults;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * true if this inbound domain has successfully set up an 
     * MX record to deliver mail to the Mandrill servers
     */
    private Boolean validMx;

    @Override
    public String toString(){
        return domain;
    }
    
    public String getDomain() {
        return domain;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Boolean getValidMx() {
        return validMx;
    }
    
}
