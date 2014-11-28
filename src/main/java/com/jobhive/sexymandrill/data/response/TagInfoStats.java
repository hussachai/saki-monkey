package com.jobhive.sexymandrill.data.response;

import java.util.Map;

import com.jobhive.sexymandrill.data.SummaryInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class TagInfoStats extends SummaryInfo{
    
    private String tag;
    
    private Map<String, SummaryInfo> stats;

    public String getTag() {
        return tag;
    }

    public TagInfoStats setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Map<String, SummaryInfo> getStats() {
        return stats;
    }
    
    public TagInfoStats setHistory(Map<String, SummaryInfo> stats) {
        this.stats = stats;
        return this;
    }
}
