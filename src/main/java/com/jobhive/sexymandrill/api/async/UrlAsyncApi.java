package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.TimedUrlInfo;
import com.jobhive.sexymandrill.data.response.TrackingDomain;
import com.jobhive.sexymandrill.data.response.UrlInfo;

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
    public Future<HttpResponse> list(ObjectResponseCallback<UrlInfo[]> callback) {
        return getClient().execute("/urls/list.json", null, callback);
    }
    
    /**
     * Return the 100 most clicked URLs that match the search query given
     * @param q a search query
     * @param callback (the 100 most clicked URLs matching the search query)
     * @return
     */
    public Future<HttpResponse> search(String q, ObjectResponseCallback<UrlInfo[]> callback) {
        return getClient().execute("/urls/search.json", mapParams("q", q), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a url
     * @param url an existing URL
     * @param callback (the array of history information)
     * @return
     */
    public Future<HttpResponse> timeSeries(String url, ObjectResponseCallback<TimedUrlInfo[]> callback) {
        return getClient().execute("/urls/time-series.json", mapParams("url", url), callback);
    }
    
    /**
     * Get the list of tracking domains set up for this account
     * @param callback (the tracking domains and their status)
     * @return
     */
    public Future<HttpResponse> trackingDomains(ObjectResponseCallback<TrackingDomain[]> callback) {
        return getClient().execute("/urls/tracking-domains.json", null, callback);
    }
    
    /**
     * Add a tracking domain to your account
     * @param domain a domain name
     * @param callback (information about the domain)
     * @return
     */
    public Future<HttpResponse> addTrackingDomain(String domain, 
            ObjectResponseCallback<TrackingDomain> callback) {
        return getClient().execute("/urls/add-tracking-domain.json", mapParams("domain", domain), callback);
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
        return getClient().execute("/urls/check-tracking-domain.json", mapParams("domain", domain), callback);
    }
}
