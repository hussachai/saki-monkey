package com.jobhive.sakimonkey.api;

import java.util.Map;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.WhitelistEntry;
import com.jobhive.sakimonkey.data.response.EmailStatus.AddedStatus;
import com.jobhive.sakimonkey.data.response.EmailStatus.DeletedStatus;

/**
 * 
 * @author Hussachai
 *
 */
public class WhitelistApi extends MandrillApi {

    public WhitelistApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Adds an email to your email rejection whitelist. 
     * If the address is currently on your blacklist, that blacklist entry 
     * will be removed automatically.
     * @param email an email address to add to the whitelist
     * @param comment an optional description of why the email was whitelisted maxlength(255)
     * @param callback (a status object containing the address and the result of the operation)
     * @return
     */
    public Result<AddedStatus> add(String email, String comment) {
        Map<String, Object> params = mapParams("email", email).p("comment", comment);
        return getClient().execute(AddedStatus.class, WHITELIST_ADD, params);
    }
    
    /**
     * @param email
     * @return
     */
    public Result<AddedStatus> add(String email) {
        return add(email, null);
    }
    
    /**
     * Retrieves your email rejection whitelist. You can provide an email address or search 
     * prefix to limit the results. Returns up to 1000 results.
     * @param email an optional email address or prefix to search by
     * @param callback (up to 1000 whitelist entries)
     * @return
     */
    public Result<WhitelistEntry[]> list(String email) {
        return getClient().execute(WhitelistEntry[].class, 
                WHITELIST_LIST, mapParams("email", email));
    }
    
    /**
     * 
     * @return
     */
    public Result<WhitelistEntry[]> list() {
        return list(null);
    }
    
    /**
     * Removes an email address from the whitelist.
     * @param email
     * @param callback (a status object containing the address and whether the deletion succeeded)
     * @return
     */
    public Result<DeletedStatus> delete(String email) {
        return getClient().execute(DeletedStatus.class, WHITELIST_DELETE, 
                mapParams("email", email));
    }
}
