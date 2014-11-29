package com.jobhive.sakimonkey.api.async;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.response.EmailStatus;
import com.jobhive.sakimonkey.data.response.RejectEntry;

/**
 * 
 * @author Hussachai
 *
 */
public class RejectAsyncApi extends MandrillAsyncApi {
    
    public RejectAsyncApi(MandrillAsyncClient client) {
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
     * @param callback
     * @return
     */
    public Future<HttpResponse> add(String email, String comment, String subaccount,
            ObjectResponseCallback<EmailStatus.AddedStatus> callback) {
        Map<String, Object> params = mapParams("email", email)
                .p("comment", comment).p("subaccount", subaccount);
        return getClient().execute(REJECT_ADD, params, callback);
    }
    
    /**
     * 
     * @param email
     * @param callback
     * @return
     */
    public Future<HttpResponse> add(String email, 
            ObjectResponseCallback<EmailStatus.AddedStatus> callback) {
        return add(email, null, null, callback);
    }
    
    /**
     * Retrieves your email rejection blacklist. You can provide an email 
     * address to limit the results. Returns up to 1000 results. 
     * By default, entries that have expired are excluded from the results; 
     * set include_expired to true to include them.
     * @param email an optional email address to search by
     * @param includExpired whether to include rejections that have already expired.
     * @param subaccount an optional unique identifier for the subaccount to limit the blacklist
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(String email, Boolean includExpired, String subaccount,
            ObjectResponseCallback<RejectEntry[]> callback) {
        Map<String, Object> params = mapParams("email", email)
                .p("include_expired", includExpired).p("subaccount", subaccount);
        return getClient().execute(REJECT_LIST, params, callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<RejectEntry[]> callback) {
        return list(null, null, null, callback);
    }
    
    /**
     * Deletes an email rejection. There is no limit to how many rejections 
     * you can remove from your blacklist, but keep in mind that each deletion 
     * has an affect on your reputation.
     * @param email an email address
     * @param subaccount an optional unique identifier for the subaccount to limit the blacklist deletion
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String email, String subaccount, 
            ObjectResponseCallback<RejectEntry[]> callback) {
        Map<String, Object> params = mapParams("email", email)
                .p("subaccount", subaccount);
        return getClient().execute(REJECT_DELETE, params, callback);
    }
    
    /**
     * 
     * @param email
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String email, 
            ObjectResponseCallback<RejectEntry[]> callback) {
        return delete(email, null, callback);
    }
}
