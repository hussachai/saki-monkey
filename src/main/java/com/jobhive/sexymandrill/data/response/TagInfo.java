package com.jobhive.sexymandrill.data.response;

import com.jobhive.sexymandrill.data.SummaryInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class TagInfo extends SummaryInfo{

    private String tag;
    
    private int reputation;

    public String getTag() {
        return tag;
    }

    public TagInfo setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public int getReputation() {
        return reputation;
    }

    public TagInfo setReputation(int reputation) {
        this.reputation = reputation;
        return this;
    }
}
