package com.jobhive.sexymandrill.data;

public class DomainRecord {
    
    private Boolean valid;
    
    private String validAfter;
    
    private String error;
    
    public Boolean getValid() {
        return valid;
    }
    
    public DomainRecord setValid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public String getValidAfter() {
        return validAfter;
    }

    public DomainRecord setValidAfter(String validAfter) {
        this.validAfter = validAfter;
        return this;
    }

    public String getError() {
        return error;
    }

    public DomainRecord setError(String error) {
        this.error = error;
        return this;
    }
    
}
