package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class Whitelist {
    
    private String email;
    
    private String detail;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;

    public String getEmail() {
        return email;
    }

    public Whitelist setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Whitelist setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Whitelist setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
