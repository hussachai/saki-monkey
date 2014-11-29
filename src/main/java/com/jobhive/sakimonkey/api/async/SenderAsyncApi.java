package com.jobhive.sakimonkey.api.async;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.response.Domain;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.TimedStats;

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
        return getClient().execute(SENDER_LIST, null, callback);
    }
    
    /**
     * Returns the sender domains that have been added to this account.
     * @param callback (an array of sender domain data, one for each sending domain used by the account)
     * @return 
     */
    public Future<HttpResponse> domains(ObjectResponseCallback<Domain[]> callback) {
        return getClient().execute(SENDER_DOMAINS, null, callback);
    }
    
    /**
     * Adds a sender domain to your account. Sender domains are added automatically 
     * as you send, but you can use this call to add them ahead of time.
     * @param domain a domain name
     * @param callback (information about the domain)
     * @return 
     */
    public Future<HttpResponse> addDomain(String domain, 
            ObjectResponseCallback<Domain> callback) {
        return getClient().execute(SENDER_ADD_DOMAIN, 
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
            ObjectResponseCallback<Domain> callback) {
        return getClient().execute(SENDER_CHECK_DOMAIN, 
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
            ObjectResponseCallback<Domain> callback) {
        Map<String, Object> params = mapParams("domain", domain).p("mailbox", mailbox);
        return getClient().execute(SENDER_VERIFY_DOMAIN, params, callback);
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
        return getClient().execute(SENDER_INFO, 
                mapParams("address", address), callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a sender
     * @param address the email address of the sender
     * @param callback (the array of history information)
     * @return 
     */
    public Future<HttpResponse> timeSerieis(String address, 
            ObjectResponseCallback<TimedStats[]> callback) {
        return getClient().execute(SENDER_TIME_SERIES, 
                mapParams("address", address), callback);
    }
}
