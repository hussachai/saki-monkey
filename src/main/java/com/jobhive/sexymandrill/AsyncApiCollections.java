package com.jobhive.sexymandrill;

import com.jobhive.sexymandrill.api.async.MessageAsyncApi;
import com.jobhive.sexymandrill.api.async.RejectAsyncApi;
import com.jobhive.sexymandrill.api.async.SenderAsyncApi;
import com.jobhive.sexymandrill.api.async.TagAsyncApi;
import com.jobhive.sexymandrill.api.async.UserAsyncApi;
import com.jobhive.sexymandrill.api.async.WhitelistAsyncApi;

/**
 * 
 * @author Hussachai
 *
 */
public class AsyncApiCollections {

    private UserAsyncApi userApi;

    private MessageAsyncApi messageApi;
    
    private TagAsyncApi tagApi;
    
    private RejectAsyncApi rejectApi;
    
    private WhitelistAsyncApi whitelistApi;
    
    private SenderAsyncApi senderApi;
    
    public AsyncApiCollections(MandrillAsyncClient client) {
        this.userApi = new UserAsyncApi(client);
        this.messageApi = new MessageAsyncApi(client);
        this.tagApi = new TagAsyncApi(client);
        this.rejectApi = new RejectAsyncApi(client);
        this.whitelistApi = new WhitelistAsyncApi(client);
        this.senderApi = new SenderAsyncApi(client);
    }
    
    public UserAsyncApi users() {
        return userApi;
    }

    public MessageAsyncApi messages() {
        return messageApi;
    }

    public TagAsyncApi tags(){
        return tagApi;
    }
    
    public RejectAsyncApi rejects(){
        return rejectApi;
    }
    
    public WhitelistAsyncApi whitelists(){
        return whitelistApi;
    }
    
    public SenderAsyncApi senders(){
        return senderApi;
    }
    
}
