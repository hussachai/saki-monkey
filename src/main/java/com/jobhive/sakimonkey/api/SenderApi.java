package com.jobhive.sakimonkey.api;

import java.util.Map;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.Domain;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.TimedStats;

/**
 * 
 * @author Hussachai
 *
 */
public class SenderApi extends MandrillApi {

    public SenderApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Return the senders that have tried to use this account.
     * @return
     */
    public Result<SenderInfo[]> list() {
        return getClient().execute(SenderInfo[].class, SENDER_LIST, null);
    }
    
    /**
     * Returns the sender domains that have been added to this account.
     * @param callback (an array of sender domain data, one for each sending domain used by the account)
     * @return 
     */
    public Result<Domain[]> domains() {
        return getClient().execute(Domain[].class, SENDER_DOMAINS, null);
    }
    
    /**
     * Adds a sender domain to your account. Sender domains are added automatically 
     * as you send, but you can use this call to add them ahead of time.
     * @param domain a domain name
     * @param callback (information about the domain)
     * @return 
     */
    public Result<Domain> addDomain(String domain) {
        return getClient().execute(Domain.class, SENDER_ADD_DOMAIN, 
                mapParams("domain", domain));
    }
    
    /**
     * Checks the SPF and DKIM settings for a domain. If you haven't already added 
     * this domain to your account, it will be added automatically.
     * 
     * @param domain a domain name
     * @param callback (information about the sender domain)
     * @return 
     */
    public Result<Domain> checkDomain(String domain) {
        return getClient().execute(Domain.class, SENDER_CHECK_DOMAIN, 
                mapParams("domain", domain));
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
    public Result<Domain> verifyDomain(String domain, String mailbox) {
        Map<String, Object> params = mapParams("domain", domain).p("mailbox", mailbox);
        return getClient().execute(Domain.class, SENDER_VERIFY_DOMAIN, params);
    }
    
    /**
     * Return more detailed information about a single sender, including aggregates 
     * of recent stats
     * @param address the email address of the sender
     * @param callback (the detailed information on the sender)
     * @return
     */
    public Result<SenderInfo> info(String address) {
        return getClient().execute(SenderInfo.class, SENDER_INFO, 
                mapParams("address", address));
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a sender
     * @param address the email address of the sender
     * @param callback (the array of history information)
     * @return 
     */
    public Result<TimedStats[]> timeSerieis(String address) {
        return getClient().execute(TimedStats[].class, SENDER_TIME_SERIES, 
                mapParams("address", address));
    }
}
