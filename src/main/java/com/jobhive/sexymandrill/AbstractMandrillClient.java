package com.jobhive.sexymandrill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jobhive.sexymandrill.data.request.ApiParam;
import com.jobhive.sexymandrill.exception.IORuntimeException;

/**
 * 
 * @author Hussachai
 *
 */
public abstract class AbstractMandrillClient {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    private MandrillContext context;
    
    public AbstractMandrillClient() {
        this(null, null);
    }
    
    public AbstractMandrillClient(MandrillContext context) {
        this.context = context;
        init();
    }
    
    public AbstractMandrillClient(String apiKey, String configPath) {
        this.context = new MandrillContext(apiKey, configPath);
        init();
    }
    
    public MandrillContext getContext() {
        return context;
    }
    
    abstract protected void init();
    
    abstract public void shutdown();
    
    
    protected String getApiKeyAsJson() {
        /* Don't bother serializer to do this simple job */
        return "{\"key\": \"" + getContext().getApiKey() + "\"}";
    }
    
    protected String convertParamsToJson(Object params) {
        if(params == null){
            log.debug("JSON param of ApiParam : [apiKey]");
            return getApiKeyAsJson();
        }else if(params instanceof ApiParam){
            ((ApiParam)params).setKey(getContext().getApiKey());
        }
        String value = null;
        try {
            value = getContext().getObjectMapper().writeValueAsString(params);
            log.debug("JSON param of {} : {}", 
                    params.getClass().getSimpleName(), value);
        } catch (JsonProcessingException e) {
            throw new IORuntimeException(e);
        }
        return value;
    }
}
