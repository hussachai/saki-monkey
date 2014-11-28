package com.jobhive.sexymandrill.data.param;

import com.jobhive.sexymandrill.utils.Assert;

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
        Assert.notNull(key, "key");
        this.key = key;
    }

}
