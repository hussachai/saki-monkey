package com.jobhive.sakimonkey.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.response.TagInfo;
import com.jobhive.sakimonkey.data.response.TimedStats;
import com.jobhive.sakimonkey.data.response.TagInfo.TagInfoStats;

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
        return getClient().execute(TAG_LIST, null, callback);
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
        return getClient().execute(TAG_DELETE, mapParams("tag", tag), callback);
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
        return getClient().execute(TAG_INFO, mapParams("tag", tag), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a tag
     * @param tag an existing tag name
     * @param callback
     * @return
     */
    public Future<HttpResponse> timeSeries(String tag, 
            ObjectResponseCallback<TimedStats[]> callback) {
        return getClient().execute(TAG_TIME_SERIES, mapParams("tag", tag), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for all tags
     * @param callback
     * @return
     */
    public Future<HttpResponse> allTimeSeries(
            ObjectResponseCallback<TimedStats[]> callback) {
        return getClient().execute(TAG_ALL_TIME_SERIES, null, callback);
    }
    
}
