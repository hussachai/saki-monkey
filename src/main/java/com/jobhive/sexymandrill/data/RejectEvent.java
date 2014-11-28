package com.jobhive.sexymandrill.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class RejectEvent {

    private String reason;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date lastEventAt;

    public String getReason() {
        return reason;
    }

    public RejectEvent setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public Date getLastEventAt() {
        return lastEventAt;
    }

    public RejectEvent setLastEventAt(Date lastEventAt) {
        this.lastEventAt = lastEventAt;
        return this;
    }
    
}
