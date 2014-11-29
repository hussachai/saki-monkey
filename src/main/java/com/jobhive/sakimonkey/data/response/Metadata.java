package com.jobhive.sakimonkey.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class Metadata {
    
    /**
     * the unique identifier of the metadata field to update
     */
    private String name;
    
    /**
     * the current state of the metadata field, 
     * one of "active", "delete", or "index"
     */
    private State state;
    
    /**
     * Mustache template to control how the metadata is rendered 
     * in your activity log
     */
    private String viewTemplate;
    
    
    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public String getViewTemplate() {
        return viewTemplate;
    }

    /**
     * 
     * @author Hussachai
     *
     */
    public static enum State {
        ACTIVE, DELETE, INDEX;
        
        @Override
        public String toString(){
            return name().toLowerCase();
        }
    }
}
