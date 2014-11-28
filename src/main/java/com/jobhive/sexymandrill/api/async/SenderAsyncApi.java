package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.SenderDomain;
import com.jobhive.sexymandrill.data.response.SenderInfo;
import com.jobhive.sexymandrill.data.response.TimedSummaryInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class SenderAsyncApi extends MandrillAsyncApi {

    public SenderAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Return the senders that have tried to use this account.
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<SenderInfo[]> callback) {
        return getClient().execute("/senders/list.json", null, callback);
    }
    
    /**
     * Returns the sender domains that have been added to this account.
     * @param callback (an array of sender domain data, one for each sending domain used by the account)
     * @return 
     */
    public Future<HttpResponse> domains(ObjectResponseCallback<SenderDomain[]> callback) {
        return getClient().execute("/senders/domains.json", null, callback);
    }
    
    /**
     * Adds a sender domain to your account. Sender domains are added automatically 
     * as you send, but you can use this call to add them ahead of time.
     * @param domain a domain name
     * @param callback (information about the domain)
     * @return 
     */
    public Future<HttpResponse> addDomain(String domain, 
            ObjectResponseCallback<SenderDomain> callback) {
        return getClient().execute("/senders/add-domain.json", 
                mapParams("domain", domain), callback);
    }
    
    /**
     * Checks the SPF and DKIM settings for a domain. If you haven't already added 
     * this domain to your account, it will be added automatically.
     * 
     * @param domain a domain name
     * @param callback (information about the sender domain)
     * @return 
     */
    public Future<HttpResponse> checkDomain(String domain, 
            ObjectResponseCallback<SenderDomain> callback) {
        return getClient().execute("/senders/check-domain.json", 
                mapParams("domain", domain), callback);
    }
    
    /**
     * 
     * Sends a verification email in order to verify ownership of a domain. 
     * Domain verification is an optional step to confirm ownership of a domain. 
     * Once a domain has been verified in a Mandrill account, other accounts may not 
     * have their messages signed by that domain unless they also verify the domain. 
     * This prevents other Mandrill accounts from sending mail signed by your domain.
     * 
     * @param domain a domain name at which you can receive email
     * @param mailbox a mailbox at the domain where the verification email should be sent
     * @param callback (information about the verification that was sent)
     * @return 
     */
    public Future<HttpResponse> verifyDomain(String domain, String mailbox, 
            ObjectResponseCallback<SenderDomain> callback) {
        return getClient().execute("/senders/verify-domain.json", 
                mapParams("domain", domain).put("mailbox", mailbox), callback);
    }
    
    /**
     * Return more detailed information about a single sender, including aggregates 
     * of recent stats
     * @param address the email address of the sender
     * @param callback (the detailed information on the sender)
     * @return
     */
    public Future<HttpResponse> info(String address, 
            ObjectResponseCallback<SenderInfo> callback) {
        return getClient().execute("/senders/info.json", 
                mapParams("address", address), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a sender
     * @param address the email address of the sender
     * @param callback (the array of history information)
     * @return 
     */
    public Future<HttpResponse> timeSerieis(String address, 
            ObjectResponseCallback<TimedSummaryInfo[]> callback) {
        return getClient().execute("/senders/time-series.json", 
                mapParams("address", address), callback);
    }
}
