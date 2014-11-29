package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class Domain {
    
    /**
     * the sender domain name
     */
    private String domain;

    /**
     * the date and time that the sending domain was first seen as a UTC string
     * in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;

    /**
     * when the domain's DNS settings were last tested as a UTC string in
     * YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date lastTestedAt;

    /**
     * details about the domain's SPF record
     */
    private DomainRecord spf;

    /**
     * details about the domain's DKIM record
     */
    private DomainRecord dkim;

    /**
     * if the domain has been verified, this indicates when that verification
     * occurred as a UTC string in YYYY-MM-DD HH:MM:SS format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date verifiedAt;

    /**
     * whether this domain can be used to authenticate mail, either for itself
     * or as a custom signing domain. If this is false but spf and dkim are both
     * valid, you will need to verify the domain before using it to authenticate
     * mail
     */
    private Boolean validSigning;

    public String getDomain() {
        return domain;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastTestedAt() {
        return lastTestedAt;
    }

    public DomainRecord getSpf() {
        return spf;
    }

    public DomainRecord getDkim() {
        return dkim;
    }

    public Date getVerifiedAt() {
        return verifiedAt;
    }

    public Boolean getValidSigning() {
        return validSigning;
    }

    /**
     * 
     * @author Hussachai
     *
     */
    public static class DomainRecord {
        
        /**
         * whether the domain's record is valid for use with Mandrill
         */
        private Boolean valid;
        
        /**
         * when the domain's DKIM record will be considered valid for use 
         * with Mandrill as a UTC string in YYYY-MM-DD HH:MM:SS format. 
         * If set, this indicates that the record is valid now, 
         * but was previously invalid, and Mandrill will wait until the 
         * record's TTL elapses to start using it.
         */
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
        private Date validAfter;
        
        /**
         * an error describing the record, or null if the record is correct
         */
        private String error;

        public Boolean getValid() {
            return valid;
        }

        public Date getValidAfter() {
            return validAfter;
        }

        public String getError() {
            return error;
        }
        
    }
}