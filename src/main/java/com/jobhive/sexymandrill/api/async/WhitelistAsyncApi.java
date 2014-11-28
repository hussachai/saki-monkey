package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.EmailAddedStatus;
import com.jobhive.sexymandrill.data.response.EmailDeletedStatus;
import com.jobhive.sexymandrill.data.response.Whitelist;

/**
 * 
 * @author Hussachai
 *
 */
public class WhitelistAsyncApi extends MandrillAsyncApi {

    public WhitelistAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Adds an email to your email rejection whitelist. 
     * If the address is currently on your blacklist, that blacklist entry 
     * will be removed automatically.
     * @param email an email address to add to the whitelist
     * @param comment an optional description of why the email was whitelisted maxlength(255)
     * @param callback (a status object containing the address and the result of the operation)
     * @return
     */
    public Future<HttpResponse> add(String email, String comment,
            ObjectResponseCallback<EmailAddedStatus> callback) {
        return getClient().execute("/whitelists/add.json", 
                mapParams("email", email).p("comment", comment), callback);
    }
    
    /**
     * @param email
     * @param callback
     * @return
     */
    public Future<HttpResponse> add(String email, 
            ObjectResponseCallback<EmailAddedStatus> callback) {
        return add(email, null, callback);
    }
    
    /**
     * Retrieves your email rejection whitelist. You can provide an email address or search 
     * prefix to limit the results. Returns up to 1000 results.
     * @param email an optional email address or prefix to search by
     * @param callback (up to 1000 whitelist entries)
     * @return
     */
    public Future<HttpResponse> list(String email, 
            ObjectResponseCallback<Whitelist[]> callback) {
        return getClient().execute("/whitelists/list.json", 
                mapParams("email", email), callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<Whitelist[]> callback) {
        return list(null, callback);
    }
    
    /**
     * Removes an email address from the whitelist.
     * @param email
     * @param callback (a status object containing the address and whether the deletion succeeded)
     * @return
     */
    public Future<HttpResponse> delete(String email, 
            ObjectResponseCallback<EmailDeletedStatus> callback) {
        return getClient().execute("/whitelists/delete.json", 
                mapParams("email", email), callback);
    }
}
