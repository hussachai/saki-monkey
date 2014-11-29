package com.jobhive.sexymandrill.api.async;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.Webhook;
import com.jobhive.sexymandrill.data.response.Webhook.MessageEvent;

/**
 * 
 * @author Hussachai
 *
 */
public class WebhookAsyncApi extends MandrillAsyncApi {

    public WebhookAsyncApi(MandrillAsyncClient client) {
        super(client);
    }

    /**
     * Get the list of all webhooks defined on the account
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<Webhook[]> callback) {
        return getClient().execute("/webhooks/list.json", null, callback);
    }
    
    /**
     * Add a new webhook
     * @param url the URL to POST batches of events
     * @param description an optional description of the webhook
     * @param events an optional list of events that will be posted to the webhook
     * @param callback
     * @return
     */
    public Future<HttpResponse> add(String url, String description, 
            List<MessageEvent> events,
            ObjectResponseCallback<Webhook> callback) {
        Map<String, Object> params = mapParams("url", url)
                .p("description", description).p("events", events);
        return getClient().execute("/webhooks/add.json", params, callback);
    }
    
    /**
     * Given the ID of an existing webhook, return the data about it
     * @param id the unique identifier of a webhook belonging to this account
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(Integer id,
            ObjectResponseCallback<Webhook> callback) {
        return getClient().execute("/webhooks/info.json", 
                mapParams("id", id), callback);
    }
    
    /**
     * Update an existing webhook
     * @param id the unique identifier of a webhook belonging to this account
     * @param url the URL to POST batches of events
     * @param description an optional description of the webhook
     * @param events an optional list of events that will be posted to the webhook
     * @param callback
     * @return
     */
    public Future<HttpResponse> update(Integer id, String url, String description, 
            List<MessageEvent> events, ObjectResponseCallback<Webhook> callback) {
        Map<String, Object> params = mapParams("url", url)
                .p("description", description).p("events", events);
        return getClient().execute("/webhooks/update.json", params, callback);
    }
    
    /**
     * Delete an existing webhook
     * @param id the unique identifier of a webhook belonging to this account
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(Integer id,
            ObjectResponseCallback<Webhook> callback) {
        return getClient().execute("/webhooks/delete.json", 
                mapParams("id", id), callback);
    }
}
