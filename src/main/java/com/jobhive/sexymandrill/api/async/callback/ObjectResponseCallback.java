package com.jobhive.sexymandrill.api.async.callback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jobhive.sexymandrill.data.response.ErrorInfo;

/**
 * 
 * @author Hussachai
 *
 * @param <T>
 */
public abstract class ObjectResponseCallback<T> {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    @SuppressWarnings("unchecked")
    public Class<T> getObjectType(){
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        return (Class<T>)((ParameterizedType) superClass).getActualTypeArguments()[0];
    }
    
    public Class<ErrorInfo> getErrorType(){
        return ErrorInfo.class;
    }
    
    public abstract void onSuccess(T object);
    
    public void onError(ErrorInfo error){
        log.error("Error code: {} message: {}", 
                error.getCode(), error.getMessage());
    }
    
    public void onFailure(Exception e) {
        log.error(e.getMessage(), e);
    }

    @SuppressWarnings("unchecked")
    public void completed(Object object, boolean isError) {
        if (isError) {
            log.info("Got error: {}", object);
            onError((ErrorInfo) object);
        } else {
            log.info("Recieved: {}", object);
            onSuccess((T) object);
        }
    }

}
