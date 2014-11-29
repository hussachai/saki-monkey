package com.jobhive.sexymandrill.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class InboundRoute {
    
    /**
     * the unique identifier of the route
     */
    private String id;
    
    /**
     * the search pattern that the mailbox name should match
     */
    private String pattern;
    
    /**
     * the webhook URL where inbound messages will be published
     */
    private String url;

    public String getId() {
        return id;
    }

    public String getPattern() {
        return pattern;
    }

    public String getUrl() {
        return url;
    }

    /**
     * the information for recipient in the message (usually one) 
     * that matched an inbound route
     * @author Hussachai
     *
     */
    public static class InboundRouteRecipient {
        
        /**
         * the email address of the matching recipient
         */
        private String email;
        
        /**
         * the mailbox route pattern that the recipient matched
         */
        private String pattern;
        
        /**
         * the webhook URL that the message was posted to
         */
        private String url;

        public String getEmail() {
            return email;
        }

        public String getPattern() {
            return pattern;
        }

        public String getUrl() {
            return url;
        }
        
    }

    
}
