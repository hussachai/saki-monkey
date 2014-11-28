package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;
import com.jobhive.sexymandrill.data.SummaryInfo;

public class SenderInfo extends SummaryInfo {

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
    
    private int reputation;

    public String getAddress() {
        return address;
    }

    public SenderInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public SenderInfo setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public int getReputation() {
        return reputation;
    }

    public SenderInfo setReputation(int reputation) {
        this.reputation = reputation;
        return this;
    }

}