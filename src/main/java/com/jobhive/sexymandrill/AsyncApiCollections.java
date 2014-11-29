package com.jobhive.sexymandrill;

import com.jobhive.sexymandrill.api.async.ExportAsyncApi;
import com.jobhive.sexymandrill.api.async.InboundAsyncApi;
import com.jobhive.sexymandrill.api.async.IpAsyncApi;
import com.jobhive.sexymandrill.api.async.MessageAsyncApi;
import com.jobhive.sexymandrill.api.async.RejectAsyncApi;
import com.jobhive.sexymandrill.api.async.SenderAsyncApi;
import com.jobhive.sexymandrill.api.async.SubaccountAsyncApi;
import com.jobhive.sexymandrill.api.async.TagAsyncApi;
import com.jobhive.sexymandrill.api.async.TemplateAsyncApi;
import com.jobhive.sexymandrill.api.async.UrlAsyncApi;
import com.jobhive.sexymandrill.api.async.UserAsyncApi;
import com.jobhive.sexymandrill.api.async.WebhookAsyncApi;
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
    
    private UrlAsyncApi urlApi;
    
    private TemplateAsyncApi templateApi;
    
    private WebhookAsyncApi webhookApi;
    
    private SubaccountAsyncApi subaccountApi;
    
    private InboundAsyncApi inboundApi;
    
    private ExportAsyncApi exportApi;
    
    private IpAsyncApi ipApi;
    
    public AsyncApiCollections(MandrillAsyncClient client) {
        userApi = new UserAsyncApi(client);
        messageApi = new MessageAsyncApi(client);
        tagApi = new TagAsyncApi(client);
        rejectApi = new RejectAsyncApi(client);
        whitelistApi = new WhitelistAsyncApi(client);
        senderApi = new SenderAsyncApi(client);
        urlApi = new UrlAsyncApi(client);
        templateApi = new TemplateAsyncApi(client);
        webhookApi = new WebhookAsyncApi(client);
        subaccountApi = new SubaccountAsyncApi(client);
        inboundApi = new InboundAsyncApi(client);
        exportApi = new ExportAsyncApi(client);
        ipApi = new IpAsyncApi(client);
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
    
    public UrlAsyncApi urls(){
        return urlApi;
    }
    
    public TemplateAsyncApi templates(){
        return templateApi;
    }
    
    public WebhookAsyncApi webhooks(){
        return webhookApi;
    }
    
    public SubaccountAsyncApi subacccounts(){
        return subaccountApi;
    }
    
    public InboundAsyncApi inbound(){
        return inboundApi;
    }
    
    public ExportAsyncApi exports(){
        return exportApi;
    }
    
    public IpAsyncApi ips(){
        return ipApi;
    }
}
