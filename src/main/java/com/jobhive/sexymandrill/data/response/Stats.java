package com.jobhive.sexymandrill.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public abstract class Stats {
    
    /**
     * the total number of messages sent
     */
    private Integer sent;

    /**
     * the number of emails hard bounced
     */
    private Integer hardBounces;

    /**
     * the number of emails soft bounced
     */
    private Integer softBounces;
    
    /**
     * the number of emails rejected for sending
     */
    private Integer rejects;

    /**
     * the number of spam complaints
     */
    private Integer complaints;

    /**
     * the number of unsubscribes
     */
    private Integer unsubs;

    /**
     * the number of times emails have been opened
     */
    private Integer opens;

    /**
     * the number of URLs that have been clicked
     */
    private Integer clicks;

    /**
     * the number of unique opens for emails sent 
     */
    private Integer uniqueOpens;

    /**
     * the number of unique clicks for emails sent
     */
    private Integer uniqueClicks;

    public Integer getSent() {
        return sent;
    }

    public Integer getHardBounces() {
        return hardBounces;
    }

    public Integer getSoftBounces() {
        return softBounces;
    }

    public Integer getRejects() {
        return rejects;
    }

    public Integer getComplaints() {
        return complaints;
    }

    public Integer getUnsubs() {
        return unsubs;
    }

    public Integer getOpens() {
        return opens;
    }

    public Integer getClicks() {
        return clicks;
    }

    public Integer getUniqueOpens() {
        return uniqueOpens;
    }

    public Integer getUniqueClicks() {
        return uniqueClicks;
    }

}
