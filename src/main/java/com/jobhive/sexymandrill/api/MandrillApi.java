package com.jobhive.sexymandrill.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jobhive.sexymandrill.AbstractMandrillClient;
import com.jobhive.sexymandrill.MandrillContext;
import com.jobhive.sexymandrill.utils.FluentMap;

/**
 * 
 * @author Hussachai
 *
 * @param <T>
 */
public abstract class MandrillApi<T extends AbstractMandrillClient> {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    private T client;

    public MandrillApi(T client) {
        this.client = client;
    }
    
    public T getClient() {
        return client;
    }
    
    public MandrillContext getContext() {
        return client.getContext();
    }
    
    public FluentMap<String, Object> mapParams(String key, Object value){
        FluentMap<String, Object> map = new FluentMap<>();
        map.put("key", getContext().getApiKey());
        map.put(key, value);
        return map;
    }
    
    
}
