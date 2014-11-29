package com.jobhive.sakimonkey.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.UserInfo;

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
        return getClient().execute(USER_INFO, null, callback);
    }
    
    /**
     * Validate an API key and respond to a ping
     * @param callback
     * @return
     */
    public Future<HttpResponse> ping(ObjectResponseCallback<String> callback) {
        return getClient().execute(USER_PING, null, callback);
    }
    
    /**
     * Return the senders that have tried to use this account, 
     * both verified and unverified
     * @param callback
     * @return
     */
    public Future<HttpResponse> senders(ObjectResponseCallback<SenderInfo[]> callback) {
        return getClient().execute(USER_SENDERS, null, callback);
    }
    
}
