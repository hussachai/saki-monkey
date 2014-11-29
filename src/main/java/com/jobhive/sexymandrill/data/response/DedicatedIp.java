package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class DedicatedIp {
    
    /**
     * the ip address
     */
    private String ip;
    
    /**
     * the date and time that the dedicated IP was created as 
     * a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    /**
     * the name of the pool that this dedicated IP belongs to
     */
    private String pool;
    
    /**
     * the domain name (reverse dns) of this dedicated IP
     */
    private String domain;
    
    /**
     * information about the ip's custom dns, if it has been configured
     */
    private CustomDns customDns;
    
    /**
     * information about the ip's warmup status
     */
    private WarmupStatus warmup;
    
    public String getIp() {
        return ip;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPool() {
        return pool;
    }

    public String getDomain() {
        return domain;
    }

    public CustomDns getCustomDns() {
        return customDns;
    }

    public WarmupStatus getWarmup() {
        return warmup;
    }

    /**
     * information about the ip's custom dns, if it has been configured
     * @author Hussachai
     *
     */
    public static class CustomDns {
        /**
         * a boolean indicating whether custom dns has been configured for this ip
         */
        private Boolean enabled;
        
        /**
         * whether the ip's custom dns is currently valid
         */
        private Boolean valid;
        
        /**
         * if the ip's custom dns is invalid, this will include details about the error
         */
        private String error;

        public Boolean getEnabled() {
            return enabled;
        }

        public Boolean getValid() {
            return valid;
        }

        public String getError() {
            return error;
        }
    }
    
    /**
     * information about the ip's warmup status
     * @author Hussachai
     *
     */
    public static class WarmupStatus {
        /**
         * whether the ip is currently in warmup mode
         */
        private Boolean warmingUp;
        
        /**
         * the start time for the warmup process as a UTC string in YYYY-MM-DD HH:MM:SS format
         */
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
        private Date startAt;
        
        /**
         * the end date and time for the warmup process as a UTC string in YYYY-MM-DD HH:MM:SS format
         */
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
        private Date endAt;

        public Boolean getWarmingUp() {
            return warmingUp;
        }

        public Date getStartAt() {
            return startAt;
        }

        public Date getEndAt() {
            return endAt;
        }
        
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class IpDeleteStatus {
        
        /**
         * the ip address
         */
        private String ip;
        
        /**
         * a boolean indicating whether the ip was successfully deleted
         */
        private Boolean deleted;

        public String getIp() {
            return ip;
        }

        public Boolean getDeleted() {
            return deleted;
        }
    }
    
    /**
     * validation results for the domain
     * @author Hussachai
     *
     */
    public static class CustomDnsStatus {
        
        /**
         * whether the domain name has a correctly-configured 
         * A record pointing to the ip address
         */
        private Boolean valid;
        
        /**
         * if valid is false, this will contain details about why 
         * the domain's A record is incorrect
         */
        private String error;

        public Boolean getValid() {
            return valid;
        }

        public String getError() {
            return error;
        }
    }
}
