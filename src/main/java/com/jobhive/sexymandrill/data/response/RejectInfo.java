package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class RejectInfo {
    
    private String email;
    
    private String reason;
    
    private String detail;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date lastEventAt;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date expiredAt;
    
    private boolean expired;
    
    private SenderInfo sender;
    
    private String subaccount;

    public String getEmail() {
        return email;
    }

    public RejectInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public RejectInfo setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public RejectInfo setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public RejectInfo setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getLastEventAt() {
        return lastEventAt;
    }

    public RejectInfo setLastEventAt(Date lastEventAt) {
        this.lastEventAt = lastEventAt;
        return this;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public RejectInfo setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    public boolean isExpired() {
        return expired;
    }

    public RejectInfo setExpired(boolean expired) {
        this.expired = expired;
        return this;
    }

    public SenderInfo getSender() {
        return sender;
    }

    public RejectInfo setSender(SenderInfo sender) {
        this.sender = sender;
        return this;
    }

    public String getSubaccount() {
        return subaccount;
    }

    public RejectInfo setSubaccount(String subaccount) {
        this.subaccount = subaccount;
        return this;
    }
    
}
