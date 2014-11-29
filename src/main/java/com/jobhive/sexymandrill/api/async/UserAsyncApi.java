package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.SenderInfo;
import com.jobhive.sexymandrill.data.response.UserInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class UserAsyncApi extends MandrillAsyncApi {

    public UserAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Return the information about the API-connected user
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(ObjectResponseCallback<UserInfo> callback) {
        return getClient().execute("/users/info.json", null, callback);
    }
    
    /**
     * Validate an API key and respond to a ping
     * @param callback
     * @return
     */
    public Future<HttpResponse> ping(ObjectResponseCallback<String> callback) {
        return getClient().execute("/users/ping.json", null, callback);
    }
    
    /**
     * Return the senders that have tried to use this account, 
     * both verified and unverified
     * @param callback
     * @return
     */
    public Future<HttpResponse> senders(ObjectResponseCallback<SenderInfo[]> callback) {
        return getClient().execute("/users/senders.json", null, callback);
    }
    
}
