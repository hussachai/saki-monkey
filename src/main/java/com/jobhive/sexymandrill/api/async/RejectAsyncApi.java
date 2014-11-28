package com.jobhive.sexymandrill.api.async;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.EmailAddedStatus;
import com.jobhive.sexymandrill.data.response.RejectInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class RejectAsyncApi extends MandrillAsyncApi {
    
    public RejectAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    public Future<HttpResponse> add(String email, String comment, String subaccount,
            ObjectResponseCallback<EmailAddedStatus> callback) {
        Map<String, Object> params = mapParams("email", email)
                .p("comment", comment).p("subaccount", subaccount);
        return getClient().execute("/rejects/add.json", params, callback);
    }
    
    public Future<HttpResponse> add(String email, 
            ObjectResponseCallback<EmailAddedStatus> callback) {
        return add(email, null, null, callback);
    }
    
    public Future<HttpResponse> list(String email, Boolean includExpired, String subaccount,
            ObjectResponseCallback<RejectInfo[]> callback) {
        Map<String, Object> params = mapParams("email", email)
                .p("include_expired", includExpired).p("subaccount", subaccount);
        return getClient().execute("/rejects/list.json", params, callback);
    }
    
    public Future<HttpResponse> list(ObjectResponseCallback<RejectInfo[]> callback) {
        return list(null, null, null, callback);
    }
    
    public Future<HttpResponse> delete(String email, String subaccount, 
            ObjectResponseCallback<RejectInfo[]> callback) {
        Map<String, Object> params = mapParams("email", email).p("subaccount", subaccount);
        return getClient().execute("/rejects/list.json", params, callback);
    }
    
    public Future<HttpResponse> delete(String email, ObjectResponseCallback<RejectInfo[]> callback) {
        return delete(email, null, callback);
    }
}
