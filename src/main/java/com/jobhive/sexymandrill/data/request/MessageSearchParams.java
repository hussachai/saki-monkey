package com.jobhive.sexymandrill.data.request;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;
import com.jobhive.sexymandrill.utils.Literal;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageSearchParams extends ApiParam  {
    
    /**
     * search terms to find matching messages
     * http://help.mandrill.com/entries/22211902
     */
    private String query;

    /**
     * start date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATE_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date dateFrom;

    /**
     * end date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATE_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date dateTo;

    /**
     * an array of tag names to narrow the search to, will return messages that
     * contain ANY of the tags
     */
    private Set<String> tags;

    /**
     * an array of sender addresses to narrow the search to, will return
     * messages sent by ANY of the senders
     */
    private Set<String> senders;
    
    /**
     * an array of API keys to narrow the search to, will return messages sent
     * by ANY of the keys
     */
    private Set<String> apiKeys;

    /**
     * the maximum number of results to return, defaults to 100, 1000 is the
     * maximum
     */
    private Integer limit;
    
    public String getQuery() {
        return query;
    }

    public MessageSearchParams setQuery(String query) {
        this.query = query;
        return this;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public MessageSearchParams setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public MessageSearchParams setDateTo(Date dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public Set<String> getTags() {
        return tags;
    }

    public MessageSearchParams setTags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public MessageSearchParams setTags(String... tags) {
        this.tags = Literal.set(tags);
        return this;
    }

    public Set<String> getSenders() {
        return senders;
    }

    public MessageSearchParams setSenders(Set<String> senders) {
        this.senders = senders;
        return this;
    }

    public MessageSearchParams setSenders(String... senders) {
        this.senders = Literal.set(senders);
        return this;
    }
    
    public Set<String> getApiKeys() {
        return apiKeys;
    }

    public MessageSearchParams setApiKeys(Set<String> apiKeys) {
        this.apiKeys = apiKeys;
        return this;
    }

    public MessageSearchParams setApiKeys(String... apiKeys) {
        this.apiKeys = Literal.set(apiKeys);
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public MessageSearchParams setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

}
