package com.jobhive.sexymandrill.data.param;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class RawMessageParams extends ApiParam{

    private String rawMessage;
    
    private String fromEmail;
    
    private String fromName;
    
    @JsonProperty("to")
    private Set<String> recipients;
    
    private Boolean async;
    
    private String ipPool;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date sendAt;
    
    private String returnPathDomain;

    public String getRawMessage() {
        return rawMessage;
    }

    public RawMessageParams setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public RawMessageParams setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public RawMessageParams setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public Set<String> getRecipients() {
        return recipients;
    }

    public RawMessageParams setRecipients(Set<String> recipients) {
        this.recipients = recipients;
        return this;
    }

    public Boolean getAsync() {
        return async;
    }

    public RawMessageParams setAsync(Boolean async) {
        this.async = async;
        return this;
    }

    public String getIpPool() {
        return ipPool;
    }

    public RawMessageParams setIpPool(String ipPool) {
        this.ipPool = ipPool;
        return this;
    }

    public Date getSendAt() {
        return sendAt;
    }

    public RawMessageParams setSendAt(Date sendAt) {
        this.sendAt = sendAt;
        return this;
    }

    public String getReturnPathDomain() {
        return returnPathDomain;
    }

    public RawMessageParams setReturnPathDomain(String returnPathDomain) {
        this.returnPathDomain = returnPathDomain;
        return this;
    }
    
}
