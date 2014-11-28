package com.jobhive.sexymandrill.data;

/**
 * the individual message event
 * 
 * This enum is used in webhook.
 * 
 * @author Hussachai
 *
 */
public enum MessageEvent {
    SEND, HARD_BOUNCE, SOFT_BOUNCE, OPEN, CLICK, SPAM, UNSUB, REJECT;
    
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}