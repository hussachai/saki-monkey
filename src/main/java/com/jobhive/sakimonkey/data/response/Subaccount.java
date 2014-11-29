package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sakimonkey.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class Subaccount {
    
    /**
     * a unique indentifier for the subaccount
     */
    private String id;
    
    /**
     * an optional display name for the subaccount
     */
    private String name;
    
    /**
     * optional extra text to associate with the subaccount
     */
    @JsonProperty("notes")
    private String note;
    /**
     * an optional manual hourly quota for the subaccount. If not specified, 
     * the hourly quota will be managed based on reputation
     */
    private Integer customQuota;
    
    /**
     * the current sending status of the subaccount, one of "active" or "paused"
     */
    private String status;
    
    /**
     * the subaccount's current reputation on a scale from 0 to 100
     */
    private Integer reputation;
    
    /**
     * the date and time that the subaccount was created as a UTC string in 
     * YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * the date and time that the subaccount first sent as a UTC string in 
     * YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date firstSentAt;
    
    /**
     * the number of emails the subaccount has sent so far this week 
     * (weeks start on midnight Monday, UTC)
     */
    private Integer sentWeekly;
    
    /**
     * the number of emails the subaccount has sent so far this month 
     * (months start on midnight of the 1st, UTC)
     */
    private Integer sentMonthly;
    
    /**
     * the number of emails the subaccount has sent since it was created
     */
    private Integer sentTotal;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public Integer getCustomQuota() {
        return customQuota;
    }

    public String getStatus() {
        return status;
    }

    public Integer getReputation() {
        return reputation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getFirstSentAt() {
        return firstSentAt;
    }

    public Integer getSentWeekly() {
        return sentWeekly;
    }

    public Integer getSentMonthly() {
        return sentMonthly;
    }

    public Integer getSentTotal() {
        return sentTotal;
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class SubaccountInfo extends Subaccount{

        /**
         * the number of emails the subaccount has sent in the last hour
         */
        private Integer sentHourly;
        
        /**
         * the current hourly quota for the subaccount, either manual or reputation-based
         */
        private Integer hourlyQuota;
        
        /**
         * stats for this subaccount in the last 30 days
         */
        @JsonProperty("last_30_days")
        private Stats last30DaysStats;

        public Integer getSentHourly() {
            return sentHourly;
        }

        public Integer getHourlyQuota() {
            return hourlyQuota;
        }

        public Stats getLast30DaysStats() {
            return last30DaysStats;
        }
        
    }

}
