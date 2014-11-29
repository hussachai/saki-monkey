package com.jobhive.sakimonkey.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public abstract class EmailStatus {
    
    public String email;
    
    public String getEmail() {
        return email;
    }
    
    public static class AddedStatus extends EmailStatus{
        
        private Boolean added;

        public Boolean getAdded() {
            return added;
        }
    }

    /**
     * 
     * @author Hussachai
     *
     */
    public static class DeletedStatus extends EmailStatus{
        
        private Boolean deleted;

        public Boolean getDeleted() {
            return deleted;
        }
    }
}
