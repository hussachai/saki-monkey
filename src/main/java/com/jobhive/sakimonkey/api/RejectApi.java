package com.jobhive.sakimonkey.api;

import java.util.Map;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.RejectEntry;
import com.jobhive.sakimonkey.data.response.EmailStatus.AddedStatus;

/**
 * 
 * @author Hussachai
 *
 */
public class RejectApi extends MandrillApi {
    
    public RejectApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Adds an email to your email rejection blacklist. Addresses that you 
     * add manually will never expire and there is no reputation penalty 
     * for removing them from your blacklist. Attempting to blacklist 
     * an address that has been whitelisted will have no effect.
     * @param email an email address to block
     * @param comment an optional comment describing the rejection
     * @param subaccount an optional unique identifier for the subaccount 
     *        to limit the blacklist entry
     * @return
     */
    public Result<AddedStatus> add(String email, String comment, String subaccount) {
        Map<String, Object> params = mapParams("email", email)
                .p("comment", comment).p("subaccount", subaccount);
        return getClient().execute(AddedStatus.class, REJECT_ADD, params);
    }
    
    /**
     * 
     * @param email
     * @return
     */
    public Result<AddedStatus> add(String email) {
        return add(email, null, null);
    }
    
    /**
     * Retrieves your email rejection blacklist. You can provide an email 
     * address to limit the results. Returns up to 1000 results. 
     * By default, entries that have expired are excluded from the results; 
     * set include_expired to true to include them.
     * @param email an optional email address to search by
     * @param includExpired whether to include rejections that have already expired.
     * @param subaccount an optional unique identifier for the subaccount to limit the blacklist
     * @return
     */
    public Result<RejectEntry[]> list(String email, Boolean includExpired, String subaccount) {
        Map<String, Object> params = mapParams("email", email)
                .p("include_expired", includExpired).p("subaccount", subaccount);
        return getClient().execute(RejectEntry[].class, REJECT_LIST, params);
    }
    
    /**
     * 
     * @return
     */
    public Result<RejectEntry[]> list() {
        return list(null, null, null);
    }
    
    /**
     * Deletes an email rejection. There is no limit to how many rejections 
     * you can remove from your blacklist, but keep in mind that each deletion 
     * has an affect on your reputation.
     * @param email an email address
     * @param subaccount an optional unique identifier for the subaccount to limit the blacklist deletion
     * @return
     */
    public Result<RejectEntry[]> delete(String email, String subaccount) {
        Map<String, Object> params = mapParams("email", email)
                .p("subaccount", subaccount);
        return getClient().execute(RejectEntry[].class, REJECT_DELETE, params);
    }
    
    /**
     * 
     * @param email
     * @return
     */
    public Result<RejectEntry[]> delete(String email) {
        return delete(email, null);
    }
    
}
