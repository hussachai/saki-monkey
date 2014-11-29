package com.jobhive.sexymandrill.api.async;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.InboundDomain;
import com.jobhive.sexymandrill.data.response.InboundRoute;
import com.jobhive.sexymandrill.data.response.InboundRoute.InboundRouteRecipient;

/**
 * 
 * @author Hussachai
 *
 */
public class InboundAsyncApi extends MandrillAsyncApi {

    public InboundAsyncApi(MandrillAsyncClient client) {
        super(client);
    }

    /**
     * List the domains that have been configured for inbound delivery
     * @param callback
     * @return
     */
    public Future<HttpResponse> domains(ObjectResponseCallback<InboundDomain[]> callback) {
        return getClient().execute("/inbound/domains.json", null, callback);
    }
    
    /**
     * Add an inbound domain to your account
     * @param domain
     * @param callback
     * @return
     */
    public Future<HttpResponse> addDomain(String domain,
            ObjectResponseCallback<InboundDomain> callback) {
        return getClient().execute("/inbound/add-domain.json", 
                mapParams("domain", domain), callback);
    }
    
    /**
     * Check the MX settings for an inbound domain. The domain must have 
     * already been added with the add-domain call
     * @param domain
     * @param callback
     * @return
     */
    public Future<HttpResponse> checkDomain(String domain,
            ObjectResponseCallback<InboundDomain> callback) {
        return getClient().execute("/inbound/check-domain.json", 
                mapParams("domain", domain), callback);
    }
    
    /**
     * Delete an inbound domain from the account. All mail will stop routing 
     * for this domain immediately.
     * @param domain
     * @param callback
     * @return
     */
    public Future<HttpResponse> deleteDomain(String domain,
            ObjectResponseCallback<InboundDomain> callback) {
        return getClient().execute("/inbound/delete-domain.json", 
                mapParams("domain", domain), callback);
    }
    
    /**
     * List the mailbox routes defined for an inbound domain
     * @param domain
     * @param callback
     * @return
     */
    public Future<HttpResponse> routes(String domain,
            ObjectResponseCallback<InboundRoute[]> callback) {
        return getClient().execute("/inbound/routes.json", 
                mapParams("domain", domain), callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> routes(ObjectResponseCallback<InboundRoute[]> callback) {
        return routes(null, callback);
    }
    
    /**
     * Add a new mailbox route to an inbound domain
     * 
     * @param domain an existing inbound domain
     * @param pattern the search pattern that the mailbox name should match
     * @param url the webhook URL where the inbound messages will be published
     * @param callback
     * @return
     */
    public Future<HttpResponse> addRoute(String domain, String pattern, String url,
            ObjectResponseCallback<InboundRoute> callback) {
        Map<String, Object> params = mapParams("domain", domain)
                .p("pattern", pattern).p("url", url);
        return getClient().execute("/inbound/add-route.json", 
                params, callback);
    }
    
    /**
     * Update the pattern or webhook of an existing inbound mailbox route. If null is provided for any fields, 
     * the values will remain unchanged.
     * @param id the unique identifier of an existing mailbox route
     * @param pattern the search pattern that the mailbox name should match
     * @param url the webhook URL where the inbound messages will be published
     * @param callback
     * @return
     */
    public Future<HttpResponse> updateRoute(String id, String pattern, String url,
            ObjectResponseCallback<InboundRoute> callback) {
        Map<String, Object> params = mapParams("id", id)
                .p("pattern", pattern).p("url", url);
        return getClient().execute("/inbound/update-route.json", 
                params, callback);
    }
    
    /**
     * Delete an existing inbound mailbox route
     * @param id the unique identifier of an existing route
     * @param callback
     * @return
     */
    public Future<HttpResponse> deleteRoute(String id,
            ObjectResponseCallback<InboundRoute> callback) {
        return getClient().execute("/inbound/delete-route.json", 
                mapParams("id", id), callback);
    }
    
    /**
     * Take a raw MIME document destined for a domain with inbound 
     * domains set up, and send it to the inbound hook exactly as 
     * if it had been sent over SMTP
     * 
     * @param rawMessage the full MIME document of an email message
     * @param toEmails optionally define the recipients to receive the message - otherwise we'll use the To, Cc, and Bcc headers provided in the document
     * @param mailFrom the address specified in the MAIL FROM stage of the SMTP conversation. Required for the SPF check.
     * @param helo the identification provided by the client mta in the MTA state of the SMTP conversation. Required for the SPF check.
     * @param clientAddress the remote MTA's ip address. Optional; required for the SPF check.
     * @param callback
     * @return
     */
    public Future<HttpResponse> sendRaw(String rawMessage,
            List<String> toEmails, String mailFrom,
            String helo, String clientAddress,
            ObjectResponseCallback<InboundRouteRecipient[]> callback) {
        Map<String, Object> params = mapParams("raw_message", rawMessage)
                .p("to", toEmails).p("mail_from", mailFrom)
                .p("helo", helo).p("client_address", clientAddress);
        return getClient().execute("/inbound/send-raw.json", 
                params, callback);
    }
}
