package com.jobhive.sakimonkey.api;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.SenderInfo;
import com.jobhive.sakimonkey.data.response.UserInfo;

/**
 * 
 * @author Hussachai
 *
 */
public class UserApi extends MandrillApi {

    public UserApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Return the information about the API-connected user
     * @return
     */
    public Result<UserInfo> info() {
        return getClient().execute(UserInfo.class, USER_INFO, null);
    }
    
    /**
     * Validate an API key and respond to a ping
     * @return
     */
    public Result<String> ping() {
        return getClient().execute(String.class, USER_PING, null);
    }
    
    /**
     * Return the senders that have tried to use this account, 
     * both verified and unverified
     * @return
     */
    public Result<SenderInfo[]> senders() {
        return getClient().execute(SenderInfo[].class, USER_SENDERS, null);
    }
    
}
