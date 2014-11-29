package com.jobhive.sakimonkey.api;

import java.util.List;
import java.util.Map;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.InboundDomain;
import com.jobhive.sakimonkey.data.response.InboundRoute;
import com.jobhive.sakimonkey.data.response.InboundRoute.InboundRouteRecipient;

/**
 * 
 * @author Hussachai
 *
 */
public class InboundApi extends MandrillApi {

    public InboundApi(MandrillClient client) {
        super(client);
    }

    /**
     * List the domains that have been configured for inbound delivery
     * @return
     */
    public Result<InboundDomain[]> domains() {
        return getClient().execute(InboundDomain[].class, INBOUND_DOMAINS, null);
    }
    
    /**
     * Add an inbound domain to your account
     * @param domain
     * @return
     */
    public Result<InboundDomain> addDomain(String domain) {
        return getClient().execute(InboundDomain.class, INBOUND_ADD_DOMAIN, 
                mapParams("domain", domain));
    }
    
    /**
     * Check the MX settings for an inbound domain. The domain must have 
     * already been added with the add-domain call
     * @param domain
     * @return
     */
    public Result<InboundDomain> checkDomain(String domain) {
        return getClient().execute(InboundDomain.class, INBOUND_CHECK_DOMAIN, 
                mapParams("domain", domain));
    }
    
    /**
     * Delete an inbound domain from the account. All mail will stop routing 
     * for this domain immediately.
     * @param domain
     * @return
     */
    public Result<InboundDomain> deleteDomain(String domain) {
        return getClient().execute(InboundDomain.class, INBOUND_DELETE_DOMAIN, 
                mapParams("domain", domain));
    }
    
    /**
     * List the mailbox routes defined for an inbound domain
     * @param domain
     * @return
     */
    public Result<InboundRoute[]> routes(String domain) {
        return getClient().execute(InboundRoute[].class, INBOUND_ROUTES, 
                mapParams("domain", domain));
    }
    
    /**
     * 
     * @return
     */
    public Result<InboundRoute[]> routes() {
        return routes(null);
    }
    
    /**
     * Add a new mailbox route to an inbound domain
     * 
     * @param domain an existing inbound domain
     * @param pattern the search pattern that the mailbox name should match
     * @param url the webhook URL where the inbound messages will be published
     * @return
     */
    public Result<InboundRoute> addRoute(String domain, String pattern, String url) {
        Map<String, Object> params = mapParams("domain", domain)
                .p("pattern", pattern).p("url", url);
        return getClient().execute(InboundRoute.class, INBOUND_ADD_ROUTE, params);
    }
    
    /**
     * Update the pattern or webhook of an existing inbound mailbox route. If null is provided for any fields, 
     * the values will remain unchanged.
     * @param id the unique identifier of an existing mailbox route
     * @param pattern the search pattern that the mailbox name should match
     * @param url the webhook URL where the inbound messages will be published
     * @return
     */
    public Result<InboundRoute> updateRoute(String id, String pattern, String url) {
        Map<String, Object> params = mapParams("id", id)
                .p("pattern", pattern).p("url", url);
        return getClient().execute(InboundRoute.class, INBOUND_UPDATE_ROUTE, params);
    }
    
    /**
     * Delete an existing inbound mailbox route
     * @param id the unique identifier of an existing route
     * @return
     */
    public Result<InboundRoute> deleteRoute(String id) {
        return getClient().execute(InboundRoute.class, INBOUND_DELETE_ROUTE, 
                mapParams("id", id));
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
     * @return
     */
    public Result<InboundRouteRecipient[]> sendRaw(String rawMessage,
            List<String> toEmails, String mailFrom,
            String helo, String clientAddress) {
        Map<String, Object> params = mapParams("raw_message", rawMessage)
                .p("to", toEmails).p("mail_from", mailFrom)
                .p("helo", helo).p("client_address", clientAddress);
        return getClient().execute(InboundRouteRecipient[].class, 
                INBOUND_SEND_RAW, params);
    }
}
