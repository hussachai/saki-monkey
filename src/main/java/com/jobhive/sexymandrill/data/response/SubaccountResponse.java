package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Hussachai
 *
 */
public class SubaccountResponse {
    
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
    private Date createdAt;
    
    /**
     * the date and time that the subaccount first sent as a UTC string in 
     * YYYY-MM-DD HH:MM:SS format
     */
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

    public SubaccountResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubaccountResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getNote() {
        return note;
    }

    public SubaccountResponse setNote(String note) {
        this.note = note;
        return this;
    }

    public Integer getCustomQuota() {
        return customQuota;
    }

    public SubaccountResponse setCustomQuota(Integer customQuota) {
        this.customQuota = customQuota;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SubaccountResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getReputation() {
        return reputation;
    }

    public SubaccountResponse setReputation(Integer reputation) {
        this.reputation = reputation;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public SubaccountResponse setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getFirstSentAt() {
        return firstSentAt;
    }

    public SubaccountResponse setFirstSentAt(Date firstSentAt) {
        this.firstSentAt = firstSentAt;
        return this;
    }

    public Integer getSentWeekly() {
        return sentWeekly;
    }

    public SubaccountResponse setSentWeekly(Integer sentWeekly) {
        this.sentWeekly = sentWeekly;
        return this;
    }

    public Integer getSentMonthly() {
        return sentMonthly;
    }

    public SubaccountResponse setSentMonthly(Integer sentMonthly) {
        this.sentMonthly = sentMonthly;
        return this;
    }

    public Integer getSentTotal() {
        return sentTotal;
    }

    public SubaccountResponse setSentTotal(Integer sentTotal) {
        this.sentTotal = sentTotal;
        return this;
    }
    
}
