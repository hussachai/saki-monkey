package com.jobhive.sakimonkey.api;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.TagInfo;
import com.jobhive.sakimonkey.data.response.TimedStats;
import com.jobhive.sakimonkey.data.response.TagInfo.TagInfoStats;

/**
 * 
 * @author Hussachai
 *
 */
public class TagApi extends MandrillApi {

    public TagApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Return all of the user-defined tag information
     * @return
     */
    public Result<TagInfo[]> list() {
        return getClient().execute(TagInfo[].class, TAG_LIST, null);
    }
    
    /**
     * Deletes a tag permanently. Deleting a tag removes the tag 
     * from any messages that have been sent, and also deletes 
     * the tag's stats. There is no way to undo this operation, 
     * so use it carefully.
     * @param tag a tag name
     * @return
     */
    public Result<TagInfo> delete(String tag) {
        return getClient().execute(TagInfo.class, TAG_DELETE, 
                mapParams("tag", tag));
    }
    
    /**
     * Return more detailed information about a single tag, 
     * including aggregates of recent stats
     * @param tag an existing tag name
     * @return
     */
    public Result<TagInfoStats> info(String tag) {
        return getClient().execute(TagInfoStats.class, TAG_INFO, 
                mapParams("tag", tag));
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a tag
     * @param tag an existing tag name
     * @return
     */
    public Result<TimedStats[]> timeSeries(String tag) {
        return getClient().execute(TimedStats[].class, TAG_TIME_SERIES, 
                mapParams("tag", tag));
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for all tags
     * @return
     */
    public Result<TimedStats[]> allTimeSeries() {
        return getClient().execute(TimedStats[].class, TAG_ALL_TIME_SERIES, null);
    }
    
}
