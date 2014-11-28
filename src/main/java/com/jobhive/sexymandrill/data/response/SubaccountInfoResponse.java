package com.jobhive.sexymandrill.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.data.SummaryInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class SubaccountInfoResponse extends SubaccountResponse{

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
    private SummaryInfo statsOfLast30days;

    public Integer getSentHourly() {
        return sentHourly;
    }

    public SubaccountInfoResponse setSentHourly(Integer sentHourly) {
        this.sentHourly = sentHourly;
        return this;
    }

    public Integer getHourlyQuota() {
        return hourlyQuota;
    }

    public SubaccountInfoResponse setHourlyQuota(Integer hourlyQuota) {
        this.hourlyQuota = hourlyQuota;
        return this;
    }

    public SummaryInfo getStatsOfLast30days() {
        return statsOfLast30days;
    }

    public SubaccountInfoResponse setStatsOfLast30days(SummaryInfo statsOfLast30days) {
        this.statsOfLast30days = statsOfLast30days;
        return this;
    }
    
}
