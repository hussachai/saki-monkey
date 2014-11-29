package com.jobhive.sakimonkey.api;

import java.util.List;
import java.util.Map;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.Webhook;
import com.jobhive.sakimonkey.data.response.Webhook.MessageEvent;

/**
 * 
 * @author Hussachai
 *
 */
public class WebhookApi extends MandrillApi {

    public WebhookApi(MandrillClient client) {
        super(client);
    }

    /**
     * Get the list of all webhooks defined on the account
     * @return
     */
    public Result<Webhook[]> list() {
        return getClient().execute(Webhook[].class, WEBHOOK_LIST, null);
    }
    
    /**
     * Add a new webhook
     * @param url the URL to POST batches of events
     * @param description an optional description of the webhook
     * @param events an optional list of events that will be posted to the webhook
     * @return
     */
    public Result<Webhook> add(String url, String description, 
            List<MessageEvent> events) {
        Map<String, Object> params = mapParams("url", url)
                .p("description", description).p("events", events);
        return getClient().execute(Webhook.class, WEBHOOK_ADD, params);
    }
    
    /**
     * Given the ID of an existing webhook, return the data about it
     * @param id the unique identifier of a webhook belonging to this account
     * @return
     */
    public Result<Webhook> info(Integer id) {
        return getClient().execute(Webhook.class, WEBHOOK_INFO, 
                mapParams("id", id));
    }
    
    /**
     * Update an existing webhook
     * @param id the unique identifier of a webhook belonging to this account
     * @param url the URL to POST batches of events
     * @param description an optional description of the webhook
     * @param events an optional list of events that will be posted to the webhook
     * @return
     */
    public Result<Webhook> update(Integer id, String url, String description, 
            List<MessageEvent> events) {
        Map<String, Object> params = mapParams("url", url)
                .p("description", description).p("events", events);
        return getClient().execute(Webhook.class, WEBHOOK_UPDATE, params);
    }
    
    /**
     * Delete an existing webhook
     * @param id the unique identifier of a webhook belonging to this account
     * @return
     */
    public Result<Webhook> delete(Integer id) {
        return getClient().execute(Webhook.class, WEBHOOK_DELETE, 
                mapParams("id", id));
    }
}
