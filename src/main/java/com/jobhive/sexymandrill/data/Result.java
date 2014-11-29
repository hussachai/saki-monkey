package com.jobhive.sexymandrill.data;

import com.jobhive.sexymandrill.data.response.ErrorInfo;

/**
 * 
 * @author Hussachai
 *
 * @param <T>
 */
public class Result<T> {
    
    protected T object;
    
    protected boolean error = false;
    
    protected ErrorInfo errorInfo;
    
    public Result(T object){
        this.object = object;
    }
    
    public Result(ErrorInfo errorInfo){
        this.error = true;
        this.errorInfo = errorInfo;
    }
    
    public T getObject() {
        return object;
    }

    public boolean isError() {
        return error;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }
    
}
