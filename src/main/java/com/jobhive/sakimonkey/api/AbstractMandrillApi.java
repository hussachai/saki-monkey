package com.jobhive.sakimonkey.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jobhive.sakimonkey.AbstractMandrillClient;
import com.jobhive.sakimonkey.MandrillContext;
import com.jobhive.sakimonkey.utils.FluentMap;

/**
 * 
 * @author Hussachai
 *
 * @param <T>
 */
public abstract class AbstractMandrillApi<T extends AbstractMandrillClient> {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    protected final String USER_INFO = "/users/info.json";
    protected final String USER_PING = "/users/ping.json";
    protected final String USER_SENDERS = "/users/senders.json";
    
    protected final String MESSAGE_SEND = "/messages/send.json";
    protected final String MESSAGE_SEND_TEMPLATE = "/messages/send-template.json";
    protected final String MESSAGE_SEARCH = "/messages/search.json";
    protected final String MESSAGE_SEARCH_TIME_SERIES = "/messages/search-time-series.json";
    protected final String MESSAGE_INFO = "/messages/info.json";
    protected final String MESSAGE_CONTENT = "/messages/content.json";
    protected final String MESSAGE_PARSE = "/messages/parse.json";
    protected final String MESSAGE_SEND_RAW = "/messages/send-raw.json";
    protected final String MESSAGE_LIST_SCHEDULED = "/messages/list-scheduled.json";
    protected final String MESSAGE_CANCEL_SCHEDULED = "/messages/cancel-scheduled.json";
    protected final String MESSAGE_RESCHEDULED = "/messages/rescheduled.json";
    
    protected final String TAG_LIST = "/tags/list.json";
    protected final String TAG_DELETE = "/tags/delete.json";
    protected final String TAG_INFO = "/tags/info.json";
    protected final String TAG_TIME_SERIES = "/tags/time-series.json";
    protected final String TAG_ALL_TIME_SERIES = "/tags/all-time-series.json";
    
    protected final String REJECT_ADD = "/rejects/add.json";
    protected final String REJECT_LIST = "/rejects/list.json";
    protected final String REJECT_DELETE = "/rejects/delete.json";
    
    protected final String WHITELIST_ADD = "/whitelists/add.json";
    protected final String WHITELIST_LIST = "/whitelists/list.json";
    protected final String WHITELIST_DELETE = "/whitelists/delete.json";
    
    protected final String SENDER_LIST = "/senders/list.json";
    protected final String SENDER_DOMAINS = "/senders/domains.json";
    protected final String SENDER_ADD_DOMAIN = "/senders/add-domain.json";
    protected final String SENDER_CHECK_DOMAIN = "/senders/check-domain.json";
    protected final String SENDER_VERIFY_DOMAIN = "/senders/verify-domain.json";
    protected final String SENDER_INFO = "/senders/info.json";
    protected final String SENDER_TIME_SERIES = "/senders/time-series.json";
    
    protected final String URL_LIST = "/urls/list.json";
    protected final String URL_SEARCH = "/urls/search.json";
    protected final String URL_TIME_SERIES = "/urls/time-series.json";
    protected final String URL_TRACKING_DOMAINS = "/urls/tracking-domains.json";
    protected final String URL_ADD_TRACKING_DOMAIN = "/urls/add-tracking-domain.json";
    protected final String URL_CHECK_TRACKING_DOMAIN = "/urls/check-tracking-domain.json";
    
    protected final String TEMPLATE_ADD = "/templates/add.json";
    protected final String TEMPLATE_INFO = "/templates/info.json";
    protected final String TEMPLATE_UPDATE = "/templates/update.json";
    protected final String TEMPLATE_PUBLISH = "/templates/publish.json";
    protected final String TEMPLATE_DELETE = "/templates/delete.json";
    protected final String TEMPLATE_LIST = "/templates/list.json";
    protected final String TEMPLATE_TIME_SERIES = "/templates/time-series.json";
    protected final String TEMPLATE_RENDER = "/templates/render.json";
    
    protected final String WEBHOOK_LIST = "/webhooks/list.json";
    protected final String WEBHOOK_ADD = "/webhooks/add.json";
    protected final String WEBHOOK_INFO = "/webhooks/info.json";
    protected final String WEBHOOK_UPDATE = "/webhooks/update.json";
    protected final String WEBHOOK_DELETE = "/webhooks/delete.json";
    
    protected final String SUBACC_LIST = "/subaccounts/list.json";
    protected final String SUBACC_ADD = "/subaccounts/add.json";
    protected final String SUBACC_INFO = "/subaccounts/info.json";
    protected final String SUBACC_UPDATE = "/subaccounts/update.json";
    protected final String SUBACC_DELETE = "/subaccounts/delete.json";
    protected final String SUBACC_PAUSE = "/subaccounts/pause.json";
    protected final String SUBACC_RESUME = "/subaccounts/resume.json";
    
    protected final String INBOUND_DOMAINS = "/inbound/domains.json";
    protected final String INBOUND_ADD_DOMAIN = "/inbound/add-domain.json";
    protected final String INBOUND_CHECK_DOMAIN = "/inbound/check-domain.json";
    protected final String INBOUND_DELETE_DOMAIN = "/inbound/delete-domain.json";
    protected final String INBOUND_ROUTES = "/inbound/routes.json";
    protected final String INBOUND_ADD_ROUTE = "/inbound/add-route.json";
    protected final String INBOUND_UPDATE_ROUTE = "/inbound/update-route.json";
    protected final String INBOUND_DELETE_ROUTE = "/inbound/delete-route.json";
    protected final String INBOUND_SEND_RAW = "/inbound/send-raw.json";
    
    protected final String EXPORT_INFO = "/exports/info.json";
    protected final String EXPORT_LIST = "/exports/list.json";
    protected final String EXPORT_REJECTS = "/exports/rejects.json";
    protected final String EXPORT_WHITELIST = "/exports/whitelist.json";
    protected final String EXPORT_ACTIVITY = "/exports/activity.json";
    
    protected final String IP_LIST = "/ips/list.json";
    protected final String IP_INFO = "/ips/info.json";
    protected final String IP_PROVISION = "/ips/provision.json";
    protected final String IP_START_WARMUP = "/ips/start-warmup.json";
    protected final String IP_CANCEL_WARMUP = "/ips/cancel-warmup.json";
    protected final String IP_SET_POOL = "/ips/set-pool.json";
    protected final String IP_DELETE = "/ips/delete.json";
    protected final String IP_LIST_POOLS = "/ips/list-pools.json";
    protected final String IP_POOL_INFO = "/ips/pool-info.json";
    protected final String IP_CREATE_POOL = "/ips/create-pool.json";
    protected final String IP_DELETE_POOL = "/ips/delete-pool.json";
    protected final String IP_CHECK_CUSTOM_DNS = "/ips/check-custom-dns.json";
    protected final String IP_SET_CUSTOM_DNS = "/ips/set-custom-dns.json";
    
    protected final String METADATA_LIST = "/metadata/list.json";
    protected final String METADATA_ADD = "/metadata/add.json";
    protected final String METADATA_UPDATE = "/metadata/update.json";
    protected final String METADATA_DELETE = "/metadata/delete.json";
    
    private T client;

    public AbstractMandrillApi(T client) {
        this.client = client;
    }
    
    protected T getClient() {
        return client;
    }
    
    protected MandrillContext getContext() {
        return client.getContext();
    }
    
    protected FluentMap<String, Object> mapParams(String key, Object value){
        FluentMap<String, Object> map = new FluentMap<>();
        map.put("key", getContext().getApiKey());
        map.put(key, value);
        return map;
    }
    
    
}
