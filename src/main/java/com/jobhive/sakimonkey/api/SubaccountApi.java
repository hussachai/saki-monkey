package com.jobhive.sakimonkey.api;

import java.util.Map;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.Subaccount;
import com.jobhive.sakimonkey.data.response.Subaccount.SubaccountInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class SubaccountApi extends MandrillApi {

    public SubaccountApi(MandrillClient client) {
        super(client);
    }

    /**
     * Get the list of subaccounts defined for the account, optionally filtered by a prefix
     * @param q an optional prefix to filter the subaccounts' ids and names
     * @return
     */
    public Result<Subaccount[]> list(String q) {
        return getClient().execute(Subaccount[].class, SUBACC_LIST, mapParams("q", q));
    }
    
    /**
     * 
     * @return
     */
    public Result<Subaccount[]> list() {
        return list(null);
    }
    
    /**
     * 
     * @param id a unique identifier for the subaccount to be used in sending calls (required + maxlength(255))
     * @param name an optional display name to further identify the subaccount
     * @param note optional extra text to associate with the subaccount
     * @param customQuota an optional manual hourly quota for the subaccount. If not specified, Mandrill will manage this based on reputation
     * @return
     */
    public Result<Subaccount> add(String id, String name, 
            String note, Integer customQuota) {
        Map<String, Object> params = mapParams("id", id).p("name", name)
                .p("notes", note).p("custom_quota", customQuota);
        return getClient().execute(Subaccount.class, SUBACC_ADD, params);
    }
    
    /**
     * Given the ID of an existing subaccount, return the data about it
     * @param id the unique identifier of the subaccount to query
     * @return
     */
    public Result<SubaccountInfo> info(String id) {
        return getClient().execute(SubaccountInfo.class, 
                SUBACC_INFO, mapParams("id", id));
    }
    
    /**
     * Update an existing subaccount
     * @param id the unique identifier of the subaccount to update
     * @param name an optional display name to further identify the subaccount
     * @param note optional extra text to associate with the subaccount
     * @param customQuota an optional manual hourly quota for the subaccount. If not specified, Mandrill will manage this based on reputation
     * @return
     */
    public Result<Subaccount> update(String id, String name, 
            String note, Integer customQuota) {
        Map<String, Object> params = mapParams("id", id).p("name", name)
                .p("notes", note).p("custom_quota", customQuota);
        return getClient().execute(Subaccount.class, SUBACC_UPDATE, params);
    }
    
    /**
     * Delete an existing subaccount. Any email related to the subaccount will be saved, but stats 
     * will be removed and any future sending calls to this subaccount will fail.
     * @param id the unique identifier of the subaccount to delete
     * @return
     */
    public Result<Subaccount> delete(String id) {
        return getClient().execute(Subaccount.class, SUBACC_DELETE, 
                mapParams("id", id));
    }
    
    /**
     * Pause a subaccount's sending. Any future emails delivered to this subaccount will be 
     * queued for a maximum of 3 days until the subaccount is resumed.
     * @param id the unique identifier of the subaccount to pause
     * @return
     */
    public Result<Subaccount> pause(String id) {
        return getClient().execute(Subaccount.class, SUBACC_PAUSE, 
                mapParams("id", id));
    }
    
    /**
     * Resume a paused subaccount's sending
     * @param id the unique identifier of the subaccount to resume
     * @return
     */
    public Result<Subaccount> resume(String id) {
        return getClient().execute(Subaccount.class, SUBACC_RESUME, 
                mapParams("id", id));
    }
}
