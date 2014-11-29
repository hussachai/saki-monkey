package com.jobhive.sakimonkey.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sakimonkey.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class RejectEntry {
    
    /**
     * the email that is blocked
     */
    private String email;
    
    /**
     * the type of event (hard-bounce, soft-bounce, spam, unsub, custom) 
     * that caused this rejection
     */
    private String reason;
    
    /**
     * extended details about the event, such as the SMTP diagnostic for 
     * bounces or the comment for manually-created rejections
     */
    private String detail;
    
    /**
     * when the email was added to the blacklist
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * the timestamp of the most recent event that either created or renewed this rejection
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date lastEventAt;
    
    /**
     * when the blacklist entry will expire (this may be in the past)
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date expiredAt;
    
    /**
     * whether the blacklist entry has expired
     */
    private Boolean expired;
    
    /**
     * the sender that this blacklist entry applies to, or null if none.
     */
    private SenderInfo sender;
    
    /**
     * the subaccount that this blacklist entry applies to, or null if none.
     */
    private String subaccount;

    public String getEmail() {
        return email;
    }

    public String getReason() {
        return reason;
    }

    public String getDetail() {
        return detail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastEventAt() {
        return lastEventAt;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public Boolean getExpired() {
        return expired;
    }

    public SenderInfo getSender() {
        return sender;
    }

    public String getSubaccount() {
        return subaccount;
    }
    
}
