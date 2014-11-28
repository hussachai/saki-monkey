package com.jobhive.sexymandrill.api.async;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.SubaccountInfoResponse;
import com.jobhive.sexymandrill.data.response.SubaccountResponse;
import com.jobhive.sexymandrill.utils.Assert;

/**
 * 
 * @author Hussachai
 *
 */
public class SubaccountAsyncApi extends MandrillAsyncApi {

    public SubaccountAsyncApi(MandrillAsyncClient client) {
        super(client);
    }

    /**
     * Get the list of subaccounts defined for the account, optionally filtered by a prefix
     * @param q an optional prefix to filter the subaccounts' ids and names
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(String q,
            ObjectResponseCallback<SubaccountResponse[]> callback) {
        return getClient().execute("/subaccounts/list.json", mapParams("q", q), callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(
            ObjectResponseCallback<SubaccountResponse[]> callback) {
        return getClient().execute("/subaccounts/list.json", null, callback);
    }
    
    /**
     * 
     * @param id a unique identifier for the subaccount to be used in sending calls (required + maxlength(255))
     * @param name an optional display name to further identify the subaccount
     * @param note optional extra text to associate with the subaccount
     * @param customQuota an optional manual hourly quota for the subaccount. If not specified, Mandrill will manage this based on reputation
     * @param callback
     * @return
     */
    public Future<HttpResponse> add(String id, String name, String note, Integer customQuota,
            ObjectResponseCallback<SubaccountResponse> callback) {
        Assert.notNull(id, "id");
        Map<String, Object> params = mapParams("id", id).p("name", name).p("notes", note)
                .p("custom_quota", customQuota);
        return getClient().execute("/subaccounts/add.json", params, callback);
    }
    
    /**
     * Given the ID of an existing subaccount, return the data about it
     * @param id the unique identifier of the subaccount to query
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(String id,
            ObjectResponseCallback<SubaccountInfoResponse> callback) {
        Assert.notEmpty(id, "id");
        return getClient().execute("/subaccounts/info.json", mapParams("id", id), callback);
    }
    
    /**
     * Update an existing subaccount
     * @param id the unique identifier of the subaccount to update
     * @param name an optional display name to further identify the subaccount
     * @param note optional extra text to associate with the subaccount
     * @param customQuota an optional manual hourly quota for the subaccount. If not specified, Mandrill will manage this based on reputation
     * @param callback
     * @return
     */
    public Future<HttpResponse> update(String id, String name, String note, Integer customQuota,
            ObjectResponseCallback<SubaccountResponse> callback) {
        Assert.notNull(id, "id");
        Map<String, Object> params = mapParams("id", id).p("name", name).p("notes", note)
                .p("custom_quota", customQuota);
        return getClient().execute("/subaccounts/update.json", params, callback);
    }
    
    /**
     * Delete an existing subaccount. Any email related to the subaccount will be saved, but stats 
     * will be removed and any future sending calls to this subaccount will fail.
     * @param id the unique identifier of the subaccount to delete
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String id,
            ObjectResponseCallback<SubaccountResponse> callback) {
        Assert.notNull(id, "id");
        return getClient().execute("/subaccounts/delete.json", mapParams("id", id), callback);
    }
    
    /**
     * Pause a subaccount's sending. Any future emails delivered to this subaccount will be 
     * queued for a maximum of 3 days until the subaccount is resumed.
     * @param id the unique identifier of the subaccount to pause
     * @param callback
     * @return
     */
    public Future<HttpResponse> pause(String id,
            ObjectResponseCallback<SubaccountResponse> callback) {
        Assert.notNull(id, "id");
        return getClient().execute("/subaccounts/pause.json", mapParams("id", id), callback);
    }
    
    /**
     * Resume a paused subaccount's sending
     * @param id the unique identifier of the subaccount to resume
     * @param callback
     * @return
     */
    public Future<HttpResponse> resume(String id,
            ObjectResponseCallback<SubaccountResponse> callback) {
        Assert.notNull(id, "id");
        return getClient().execute("/subaccounts/resume.json", mapParams("id", id), callback);
    }
}
