package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class SenderInfo extends Stats {
    
    /**
     * the sender's email address
     */
    private String address;

    /**
     * the date and time that the sender was first seen by Mandrill 
     * as a UTC date string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    private Integer reputation;

    public String getAddress() {
        return address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Integer getReputation() {
        return reputation;
    }

}