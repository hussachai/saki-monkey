package com.jobhive.sakimonkey.data.response;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sakimonkey.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageInfo {

    /**
     * the Unix timestamp from when this message was sent
     */
    @JsonProperty("ts")
    private Integer timestamp;

    /**
     * the message's unique id
     */
    @JsonProperty("_id")
    private String id;

    /**
     * the email address of the sender
     */
    private String sender;

    /**
     * the unique name of the template used, if any
     */
    private String template;

    /**
     * the message's subject line
     */
    private String subject;

    /**
     * the recipient email address
     */
    private String email;

    /**
     * list of tags on this message
     */
    private String[] tags;

    /**
     * how many times has this message been opened
     */
    private Integer opens;

    /**
     * list of individual opens for the message
     */
    @JsonProperty("opens_detail")
    private OpenDetail[] openDetails;

    /**
     * how many times has a link been clicked in this message
     */
    private Integer clicks;

    /**
     * list of individual clicks for the message
     */
    @JsonProperty("clicks_detail")
    private ClickDetail[] clickDetails;

    /**
     * sending status of this message: sent, bounced, rejected
     */
    private String state;

    /**
     * any custom metadata provided when the message was sent
     */
    private Map<String, String> metadata;

    private String bounceDescription;

    @JsonProperty("reject")
    private RejectEvent[] rejects;
    
    /**
     * a log of up to 3 smtp events for the message
     */
    private SmtpEvent[] smtpEvents;
    
    
    public Integer getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getTemplate() {
        return template;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    public String[] getTags() {
        return tags;
    }

    public Integer getOpens() {
        return opens;
    }

    public OpenDetail[] getOpenDetails() {
        return openDetails;
    }

    public Integer getClicks() {
        return clicks;
    }

    public ClickDetail[] getClickDetails() {
        return clickDetails;
    }

    public String getState() {
        return state;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public String getBounceDescription() {
        return bounceDescription;
    }

    public RejectEvent[] getRejects() {
        return rejects;
    }

    public SmtpEvent[] getSmtpEvents() {
        return smtpEvents;
    }

    public static class OpenDetail {

        /**
         * the unix timestamp from when the message was opened/clicked
         */
        @JsonProperty("ts")
        private Integer timestamp;

        /**
         * the IP address that generated the open/click
         */
        private String ip;

        /**
         * the approximate region and country that the opening IP is located
         */
        private String location;

        /**
         * the email client or browser data of the open/click
         */
        @JsonProperty("ua")
        private String userAgent;

        public Integer getTimestamp() {
            return timestamp;
        }

        public String getIp() {
            return ip;
        }

        public String getLocation() {
            return location;
        }

        public String getUserAgent() {
            return userAgent;
        }

    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class ClickDetail extends OpenDetail {

        /**
         * the URL that was clicked on
         */
        private String url;

        public String getUrl() {
            return url;
        }
        
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class RejectEvent {

        private String reason;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
        private Date lastEventAt;

        public String getReason() {
            return reason;
        }

        public Date getLastEventAt() {
            return lastEventAt;
        }
    }
    
    /**
     * information about a specific smtp event
     * 
     * @author Hussachai
     *
     */
    public static class SmtpEvent {

        /**
         * the Unix timestamp when the event occured
         */
        @JsonProperty("ts")
        private Integer timestamp;
        
        /**
         * the message's state as a result of this event
         */
        private String type;
        
        /**
         * the SMTP response from the recipient's server
         */
        private String diag;

        public Integer getTimestamp() {
            return timestamp;
        }

        public String getType() {
            return type;
        }

        public String getDiag() {
            return diag;
        }
    }
}
