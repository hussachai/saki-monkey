package com.jobhive.sakimonkey.data.response;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Hussachai
 *
 */
public class UserInfo {

    /**
     * the username of the user (used for SMTP authentication)
     */
    private String username;

    /**
     * the date and time that the user's Mandrill account 
     * was created as a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date createdAt;

    /**
     * a unique, permanent identifier for this user
     */
    private String publicId;

    /**
     * the reputation of the user on a scale from 0 to 100, 
     * with 75 generally being a "good" reputation
     */
    private Integer reputation;

    /**
     * the maximum number of emails Mandrill will deliver for this user each hour. 
     * Any emails beyond that will be accepted and queued for later delivery. 
     * Users with higher reputations will have higher hourly quotas
     */
    private Integer hourlyQuota;

    /**
     * the number of emails that are queued for delivery due to exceeding 
     * your monthly or hourly quotas
     */
    private Integer backlog;

    /**
     * an aggregate summary of the account's sending stats
     */
    private Map<String, Stats> stats;

    public String getUsername() {
        return username;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPublicId() {
        return publicId;
    }

    public Integer getReputation() {
        return reputation;
    }

    public Integer getHourlyQuota() {
        return hourlyQuota;
    }

    public Integer getBacklog() {
        return backlog;
    }

    public Map<String, Stats> getStats() {
        return stats;
    }
    
}
