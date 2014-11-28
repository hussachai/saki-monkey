package com.jobhive.sexymandrill.data;

/**
 * a message state
 * 
 * This enum is used in Exports.activity
 * @author Hussachai
 *
 */
public enum MessageState {
    
    SENT("sent"), 
    REJECTED("rejected"), 
    BOUNCED("bounced"), 
    SOFT_BOUNCED("soft-bounced"), 
    SPAM("spam"), 
    UNSUB("unsub");
    
    private String value;

    MessageState(String value) {
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value;
    }
}
