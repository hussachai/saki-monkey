package com.jobhive.sakimonkey.data.response;

/**
 * 
 * @author Hussachai
 *
 */
public class ErrorInfo {

    private String status;

    private int code;

    private String name;

    private String message;

    @Override
    public String toString() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }  
    
}
