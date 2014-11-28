package com.jobhive.sexymandrill.data.response;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.data.SummaryInfo;

public class UserInfo {

    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date createdAt;

    private String publicId;

    private int reputation;

    private int hourlyQuota;

    private int backlog;

    private Map<String, SummaryInfo> stats;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getHourlyQuota() {
        return hourlyQuota;
    }

    public void setHourlyQuota(int hourlyQuota) {
        this.hourlyQuota = hourlyQuota;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    public Map<String, SummaryInfo> getStats() {
        return stats;
    }

    public void setStats(Map<String, SummaryInfo> stats) {
        this.stats = stats;
    }
    
}
