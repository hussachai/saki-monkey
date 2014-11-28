package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.SenderInfo;
import com.jobhive.sexymandrill.data.response.UserInfo;

public class UserAsyncApi extends MandrillAsyncApi {

    public UserAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    public Future<HttpResponse> info(ObjectResponseCallback<UserInfo> callback) {
        return getClient().execute("/users/info.json", null, callback);
    }
    
    public Future<HttpResponse> ping(ObjectResponseCallback<String> callback) {
        return getClient().execute("/users/ping.json", null, callback);
    }
    
    public Future<HttpResponse> senders(ObjectResponseCallback<SenderInfo[]> callback) {
        return getClient().execute("/users/senders.json", null, callback);
    }
    
}
