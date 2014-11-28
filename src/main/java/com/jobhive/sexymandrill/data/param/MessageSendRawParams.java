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
public class MessageSendRawParams extends ApiParam{

    /**
     * the full MIME document of an email message
     */
    private String rawMessage;
    
    /**
     * optionally define the sender address - otherwise we'll use the address found in the provided headers
     */
    private String fromEmail;
    
    /**
     * optionally define the sender alias
     */
    private String fromName;
    
    /**
     * optionally define the recipients to receive the message - otherwise we'll use the 
     * To, Cc, and Bcc headers provided in the document
     */
    @JsonProperty("to")
    private Set<String> toEmails;
    
    /**
     * enable a background sending mode that is optimized for bulk sending. 
     * In async mode, messages/sendRaw will immediately return a status of "queued" 
     * for every recipient. To handle rejections when sending in async mode, set up 
     * a webhook for the 'reject' event. Defaults to false for messages with no more 
     * than 10 recipients; messages with more than 10 recipients are always sent 
     * asynchronously, regardless of the value of async.
     */
    private Boolean async;
    
    /**
     * the name of the dedicated ip pool that should be used to send the message. 
     * If you do not have any dedicated IPs, this parameter has no effect. 
     * If you specify a pool that does not exist, your default pool will be used instead.
     */
    private String ipPool;
    
    /**
     * when this message should be sent as a UTC timestamp in YYYY-MM-DD HH:MM:SS format. 
     * If you specify a time in the past, the message will be sent immediately.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date sendAt;
    
    /**
     * a custom domain to use for the messages's return-path
     */
    private String returnPathDomain;

    public String getRawMessage() {
        return rawMessage;
    }

    public MessageSendRawParams setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public MessageSendRawParams setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public MessageSendRawParams setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public Set<String> getToEmails() {
        return toEmails;
    }

    public MessageSendRawParams setToEmails(Set<String> toEmails) {
        this.toEmails = toEmails;
        return this;
    }

    public Boolean getAsync() {
        return async;
    }

    public MessageSendRawParams setAsync(Boolean async) {
        this.async = async;
        return this;
    }

    public String getIpPool() {
        return ipPool;
    }

    public MessageSendRawParams setIpPool(String ipPool) {
        this.ipPool = ipPool;
        return this;
    }

    public Date getSendAt() {
        return sendAt;
    }

    public MessageSendRawParams setSendAt(Date sendAt) {
        this.sendAt = sendAt;
        return this;
    }

    public String getReturnPathDomain() {
        return returnPathDomain;
    }

    public MessageSendRawParams setReturnPathDomain(String returnPathDomain) {
        this.returnPathDomain = returnPathDomain;
        return this;
    }
    
}
