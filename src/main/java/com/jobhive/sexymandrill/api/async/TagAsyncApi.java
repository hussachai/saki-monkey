package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.TagInfo;
import com.jobhive.sexymandrill.data.response.TagInfo.TagInfoStats;
import com.jobhive.sexymandrill.data.response.TimedStats;

/**
 * 
 * @author Hussachai
 *
 */
public class TagAsyncApi extends MandrillAsyncApi {

    public TagAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Return all of the user-defined tag information
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<TagInfo[]> callback) {
        return getClient().execute("/tags/list.json", null, callback);
    }
    
    /**
     * Deletes a tag permanently. Deleting a tag removes the tag 
     * from any messages that have been sent, and also deletes 
     * the tag's stats. There is no way to undo this operation, 
     * so use it carefully.
     * @param tag a tag name
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String tag, 
            ObjectResponseCallback<TagInfo> callback) {
        return getClient().execute("/tags/delete.json", 
                mapParams("tag", tag), callback);
    }
    
    /**
     * Return more detailed information about a single tag, 
     * including aggregates of recent stats
     * @param tag an existing tag name
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(String tag, 
            ObjectResponseCallback<TagInfoStats> callback) {
        return getClient().execute("/tags/info.json", 
                mapParams("tag", tag), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a tag
     * @param tag an existing tag name
     * @param callback
     * @return
     */
    public Future<HttpResponse> timeSeries(String tag, 
            ObjectResponseCallback<TimedStats[]> callback) {
        return getClient().execute("/tags/time-series.json", 
                mapParams("tag", tag), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for all tags
     * @param callback
     * @return
     */
    public Future<HttpResponse> allTimeSeries(
            ObjectResponseCallback<TimedStats[]> callback) {
        return getClient().execute("/tags/all-time-series.json", null, callback);
    }
    
}
