package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.TagInfo;
import com.jobhive.sexymandrill.data.response.TagInfoStats;
import com.jobhive.sexymandrill.data.response.TimedSummaryInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class TagAsyncApi extends MandrillAsyncApi {

    public TagAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    public Future<HttpResponse> list(ObjectResponseCallback<TagInfo[]> callback) {
        return getClient().execute("/tags/list.json", null, callback);
    }
    
    public Future<HttpResponse> delete(String tag, ObjectResponseCallback<TagInfo> callback) {
        return getClient().execute("/tags/delete.json", mapParams("tag", tag), callback);
    }
    
    public Future<HttpResponse> info(String tag, ObjectResponseCallback<TagInfoStats> callback) {
        return getClient().execute("/tags/info.json", mapParams("tag", tag), callback);
    }
    
    public Future<HttpResponse> timeSeries(String tag, 
            ObjectResponseCallback<TimedSummaryInfo[]> callback) {
        return getClient().execute("/tags/time-series.json", mapParams("tag", tag), callback);
    }
    
    public Future<HttpResponse> allTimeSeries(ObjectResponseCallback<TimedSummaryInfo[]> callback) {
        return getClient().execute("/tags/all-time-series.json", null, callback);
    }
    
}
