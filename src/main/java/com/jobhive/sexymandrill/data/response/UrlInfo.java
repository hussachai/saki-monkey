package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class UrlInfo {
    
    /**
     * the URL to be tracked
     */
    private String url;
    
    /**
     * the number of emails that contained the URL
     */
    private Integer sent;
    
    /**
     * the number of times the URL has been clicked from a tracked email
     */
    private Integer clicks;
    
    /**
     * the number of unique emails that have generated clicks for this URL
     */
    private Integer uniqueClicks;
    
    public String getUrl() {
        return url;
    }

    public Integer getSent() {
        return sent;
    }

    public Integer getClicks() {
        return clicks;
    }

    public Integer getUniqueClicks() {
        return uniqueClicks;
    }

    public static class TimedUrlInfo extends UrlInfo {

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
        private Date time;

        public Date getTime() {
            return time;
        }
    }
}
