package com.jobhive.sakimonkey.data.response;

import java.util.Map;

/**
 * 
 * @author Hussachai
 *
 */
public class TagInfo extends Stats{

    /**
     * the actual tag as a string
     */
    private String tag;
    
    /**
     * the tag's current reputation on a scale from 0 to 100.
     */
    private Integer reputation;

    public String getTag() {
        return tag;
    }

    public Integer getReputation() {
        return reputation;
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class TagInfoStats extends Stats{
        
        private String tag;
        
        private Map<String, Stats> stats;

        public String getTag() {
            return tag;
        }

        public TagInfoStats setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Map<String, Stats> getStats() {
            return stats;
        }
        
        public TagInfoStats setHistory(Map<String, Stats> stats) {
            this.stats = stats;
            return this;
        }
    }
}
