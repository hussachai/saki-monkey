package com.jobhive.sakimonkey;

import com.jobhive.sakimonkey.api.async.ExportAsyncApi;
import com.jobhive.sakimonkey.api.async.InboundAsyncApi;
import com.jobhive.sakimonkey.api.async.IpAsyncApi;
import com.jobhive.sakimonkey.api.async.MessageAsyncApi;
import com.jobhive.sakimonkey.api.async.MetadataAsyncApi;
import com.jobhive.sakimonkey.api.async.RejectAsyncApi;
import com.jobhive.sakimonkey.api.async.SenderAsyncApi;
import com.jobhive.sakimonkey.api.async.SubaccountAsyncApi;
import com.jobhive.sakimonkey.api.async.TagAsyncApi;
import com.jobhive.sakimonkey.api.async.TemplateAsyncApi;
import com.jobhive.sakimonkey.api.async.UrlAsyncApi;
import com.jobhive.sakimonkey.api.async.UserAsyncApi;
import com.jobhive.sakimonkey.api.async.WebhookAsyncApi;
import com.jobhive.sakimonkey.api.async.WhitelistAsyncApi;

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
    
    private MetadataAsyncApi metadataApi;
    
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
        metadataApi = new MetadataAsyncApi(client);
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
    
    public MetadataAsyncApi metadata(){
        return metadataApi;
    }
}
