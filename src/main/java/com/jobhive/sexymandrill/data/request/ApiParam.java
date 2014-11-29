package com.jobhive.sexymandrill.data.request;


/**
 * 
 * @author Hussachai
 *
 */
public abstract class ApiParam {
    
    /**
     * a valid API key
     */
    private String key;

    public ApiParam(){}
    
    public ApiParam(String key){
        setKey(key);
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
