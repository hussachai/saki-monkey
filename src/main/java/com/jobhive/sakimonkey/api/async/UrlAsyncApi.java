package com.jobhive.sakimonkey.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.response.TrackingDomain;
import com.jobhive.sakimonkey.data.response.UrlInfo;
import com.jobhive.sakimonkey.data.response.UrlInfo.TimedUrlInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class UrlAsyncApi extends MandrillAsyncApi {

    public UrlAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Get the 100 most clicked URLs
     * @param callback (the 100 most clicked URLs and their stats)
     * @return
     */
    public Future<HttpResponse> list(
            ObjectResponseCallback<UrlInfo[]> callback) {
        return getClient().execute(URL_LIST, null, callback);
    }
    
    /**
     * Return the 100 most clicked URLs that match the search query given
     * @param q a search query
     * @param callback (the 100 most clicked URLs matching the search query)
     * @return
     */
    public Future<HttpResponse> search(String q, 
            ObjectResponseCallback<UrlInfo[]> callback) {
        return getClient().execute(URL_SEARCH, mapParams("q", q), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a url
     * @param url an existing URL
     * @param callback (the array of history information)
     * @return
     */
    public Future<HttpResponse> timeSeries(String url, 
            ObjectResponseCallback<TimedUrlInfo[]> callback) {
        return getClient().execute(URL_TIME_SERIES, 
                mapParams("url", url), callback);
    }
    
    /**
     * Get the list of tracking domains set up for this account
     * @param callback (the tracking domains and their status)
     * @return
     */
    public Future<HttpResponse> trackingDomains(
            ObjectResponseCallback<TrackingDomain[]> callback) {
        return getClient().execute(URL_TRACKING_DOMAINS, null, callback);
    }
    
    /**
     * Add a tracking domain to your account
     * @param domain a domain name
     * @param callback (information about the domain)
     * @return
     */
    public Future<HttpResponse> addTrackingDomain(String domain, 
            ObjectResponseCallback<TrackingDomain> callback) {
        return getClient().execute(URL_ADD_TRACKING_DOMAIN, 
                mapParams("domain", domain), callback);
    }
    
    /**
     * Checks the CNAME settings for a tracking domain. The domain must have been 
     * added already with the add-tracking-domain call
     * @param domain an existing tracking domain name
     * @param callback (information about the tracking domain)
     * @return
     */
    public Future<HttpResponse> checkTrackingDomain(String domain, 
            ObjectResponseCallback<TrackingDomain> callback) {
        return getClient().execute(URL_CHECK_TRACKING_DOMAIN, 
                mapParams("domain", domain), callback);
    }
}
