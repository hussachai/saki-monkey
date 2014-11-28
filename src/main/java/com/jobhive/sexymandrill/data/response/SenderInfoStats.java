package com.jobhive.sexymandrill.data.response;

import java.util.Map;

import com.jobhive.sexymandrill.data.SummaryInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class SenderInfoStats extends SenderInfo {
    
    private Map<String, SummaryInfo> stats;
    
    public Map<String, SummaryInfo> getStats() {
        return stats;
    }

    public SenderInfoStats setStats(Map<String, SummaryInfo> stats) {
        this.stats = stats;
        return this;
    }
    
}