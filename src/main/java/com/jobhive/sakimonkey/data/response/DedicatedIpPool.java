package com.jobhive.sakimonkey.data.response;

import java.util.Date;

/**
 * 
 * @author Hussachai
 *
 */
public class DedicatedIpPool {
    
    /**
     * this pool's name
     */
    private String name;
    
    /**
     * the date and time that this pool was created as 
     * a UTC timestamp in YYYY-MM-DD HH:MM:SS format
     */
    private Date createdAt;
    
    /**
     * the dedicated IPs in this pool
     */
    private DedicatedIp[] ips;

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public DedicatedIp[] getIps() {
        return ips;
    }
    
    public static class PoolDeleteStatus {
        
        /**
         * the ip address
         */
        private String pool;
        
        /**
         * whether the pool was deleted
         */
        private Boolean deleted;

        public String getPool() {
            return pool;
        }

        public Boolean getDeleted() {
            return deleted;
        }
    }
        
}
