package com.jobhive.sakimonkey.api;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.TrackingDomain;
import com.jobhive.sakimonkey.data.response.UrlInfo;
import com.jobhive.sakimonkey.data.response.UrlInfo.TimedUrlInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class UrlApi extends MandrillApi {

    public UrlApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Get the 100 most clicked URLs
     * @return
     */
    public Result<UrlInfo[]> list() {
        return getClient().execute(UrlInfo[].class, URL_LIST, null);
    }
    
    /**
     * Return the 100 most clicked URLs that match the search query given
     * @param q a search query
     * @return
     */
    public Result<UrlInfo[]> search(String q) {
        return getClient().execute(UrlInfo[].class, 
                URL_SEARCH, mapParams("q", q));
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a url
     * @param url an existing URL
     * @return
     */
    public Result<TimedUrlInfo[]> timeSeries(String url) {
        return getClient().execute(TimedUrlInfo[].class, URL_TIME_SERIES, 
                mapParams("url", url));
    }
    
    /**
     * Get the list of tracking domains set up for this account
     * @return
     */
    public Result<TrackingDomain[]> trackingDomains() {
        return getClient().execute(TrackingDomain[].class, 
                URL_TRACKING_DOMAINS, null);
    }
    
    /**
     * Add a tracking domain to your account
     * @param domain a domain name
     * @return
     */
    public Result<TrackingDomain> addTrackingDomain(String domain) {
        return getClient().execute(TrackingDomain.class, 
                URL_ADD_TRACKING_DOMAIN, mapParams("domain", domain));
    }
    
    /**
     * Checks the CNAME settings for a tracking domain. The domain must have been 
     * added already with the add-tracking-domain call
     * @param domain an existing tracking domain name
     * @return
     */
    public Result<TrackingDomain> checkTrackingDomain(String domain) {
        return getClient().execute(TrackingDomain.class, URL_CHECK_TRACKING_DOMAIN, 
                mapParams("domain", domain));
    }
}
