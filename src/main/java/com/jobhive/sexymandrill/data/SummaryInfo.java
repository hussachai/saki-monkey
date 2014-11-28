package com.jobhive.sexymandrill.data;

/**
 * 
 * @author Hussachai
 *
 */
public class SummaryInfo {
    
    /**
     * the total number of messages sent
     */
    private int sent;

    /**
     * the number of emails hard bounced
     */
    private int hardBounces;

    /**
     * the number of emails soft bounced
     */
    private int softBounces;

    /**
     * the number of emails rejected for sending
     */
    private int rejects;

    /**
     * the number of spam complaints
     */
    private int complaints;

    /**
     * the number of unsubscribes
     */
    private int unsubs;

    /**
     * the number of times emails have been opened
     */
    private int opens;

    /**
     * the number of URLs that have been clicked
     */
    private int clicks;

    /**
     * the number of unique opens for emails sent 
     */
    private int uniqueOpens;

    /**
     * the number of unique clicks for emails sent
     */
    private int uniqueClicks;

    public int getSent() {
        return sent;
    }

    public int getHardBounces() {
        return hardBounces;
    }

    public int getSoftBounces() {
        return softBounces;
    }

    public int getRejects() {
        return rejects;
    }

    public int getComplaints() {
        return complaints;
    }

    public int getUnsubs() {
        return unsubs;
    }

    public int getOpens() {
        return opens;
    }

    public int getClicks() {
        return clicks;
    }

    public int getUniqueOpens() {
        return uniqueOpens;
    }

    public int getUniqueClicks() {
        return uniqueClicks;
    }

}
