package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;
import com.jobhive.sexymandrill.data.DomainRecord;

public class SenderDomain {

    private String domain;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date createdAt;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date lastTestedAt;
    
    private DomainRecord spf;
    
    private DomainRecord dkim;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date verifiedAt;
    
    private Boolean validSigning;

    public String getDomain() {
        return domain;
    }

    public SenderDomain setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public SenderDomain setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getLastTestedAt() {
        return lastTestedAt;
    }

    public SenderDomain setLastTestedAt(Date lastTestedAt) {
        this.lastTestedAt = lastTestedAt;
        return this;
    }

    public DomainRecord getSpf() {
        return spf;
    }

    public SenderDomain setSpf(DomainRecord spf) {
        this.spf = spf;
        return this;
    }

    public DomainRecord getDkim() {
        return dkim;
    }

    public SenderDomain setDkim(DomainRecord dkim) {
        this.dkim = dkim;
        return this;
    }

    public Date getVerifiedAt() {
        return verifiedAt;
    }

    public SenderDomain setVerifiedAt(Date verifiedAt) {
        this.verifiedAt = verifiedAt;
        return this;
    }

    public Boolean getValidSigning() {
        return validSigning;
    }

    public SenderDomain setValidSigning(Boolean validSigning) {
        this.validSigning = validSigning;
        return this;
    }
    
}
