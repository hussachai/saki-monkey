package com.jobhive.sakimonkey.api.async;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.response.Subaccount;
import com.jobhive.sakimonkey.data.response.Subaccount.SubaccountInfo;

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
            ObjectResponseCallback<Subaccount[]> callback) {
        return getClient().execute(SUBACC_LIST, mapParams("q", q), callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(
            ObjectResponseCallback<Subaccount[]> callback) {
        return list(null, callback);
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
            ObjectResponseCallback<Subaccount> callback) {
        Map<String, Object> params = mapParams("id", id).p("name", name)
                .p("notes", note).p("custom_quota", customQuota);
        return getClient().execute(SUBACC_ADD, params, callback);
    }
    
    /**
     * Given the ID of an existing subaccount, return the data about it
     * @param id the unique identifier of the subaccount to query
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(String id,
            ObjectResponseCallback<SubaccountInfo> callback) {
        return getClient().execute(SUBACC_INFO, 
                mapParams("id", id), callback);
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
            ObjectResponseCallback<Subaccount> callback) {
        Map<String, Object> params = mapParams("id", id).p("name", name)
                .p("notes", note).p("custom_quota", customQuota);
        return getClient().execute(SUBACC_UPDATE, params, callback);
    }
    
    /**
     * Delete an existing subaccount. Any email related to the subaccount will be saved, but stats 
     * will be removed and any future sending calls to this subaccount will fail.
     * @param id the unique identifier of the subaccount to delete
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String id,
            ObjectResponseCallback<Subaccount> callback) {
        return getClient().execute(SUBACC_DELETE, 
                mapParams("id", id), callback);
    }
    
    /**
     * Pause a subaccount's sending. Any future emails delivered to this subaccount will be 
     * queued for a maximum of 3 days until the subaccount is resumed.
     * @param id the unique identifier of the subaccount to pause
     * @param callback
     * @return
     */
    public Future<HttpResponse> pause(String id,
            ObjectResponseCallback<Subaccount> callback) {
        return getClient().execute(SUBACC_PAUSE, 
                mapParams("id", id), callback);
    }
    
    /**
     * Resume a paused subaccount's sending
     * @param id the unique identifier of the subaccount to resume
     * @param callback
     * @return
     */
    public Future<HttpResponse> resume(String id,
            ObjectResponseCallback<Subaccount> callback) {
        return getClient().execute(SUBACC_RESUME, 
                mapParams("id", id), callback);
    }
}
