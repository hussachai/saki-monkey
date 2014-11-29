package com.jobhive.sexymandrill;

import com.jobhive.sexymandrill.api.ExportApi;
import com.jobhive.sexymandrill.api.InboundApi;
import com.jobhive.sexymandrill.api.IpApi;
import com.jobhive.sexymandrill.api.MessageApi;
import com.jobhive.sexymandrill.api.MetadataApi;
import com.jobhive.sexymandrill.api.RejectApi;
import com.jobhive.sexymandrill.api.SenderApi;
import com.jobhive.sexymandrill.api.SubaccountApi;
import com.jobhive.sexymandrill.api.TagApi;
import com.jobhive.sexymandrill.api.TemplateApi;
import com.jobhive.sexymandrill.api.UrlApi;
import com.jobhive.sexymandrill.api.UserApi;
import com.jobhive.sexymandrill.api.WebhookApi;
import com.jobhive.sexymandrill.api.WhitelistApi;

/**
 * 
 * @author Hussachai
 *
 */
public class ApiCollections {

    private UserApi userApi;

    private MessageApi messageApi;
    
    private TagApi tagApi;
    
    private RejectApi rejectApi;
    
    private WhitelistApi whitelistApi;
    
    private SenderApi senderApi;
    
    private UrlApi urlApi;
    
    private TemplateApi templateApi;
    
    private WebhookApi webhookApi;
    
    private SubaccountApi subaccountApi;
    
    private InboundApi inboundApi;
    
    private ExportApi exportApi;
    
    private IpApi ipApi;
    
    private MetadataApi metadataApi;
    
    public ApiCollections(MandrillClient client) {
        userApi = new UserApi(client);
        messageApi = new MessageApi(client);
        tagApi = new TagApi(client);
        rejectApi = new RejectApi(client);
        whitelistApi = new WhitelistApi(client);
        senderApi = new SenderApi(client);
        urlApi = new UrlApi(client);
        templateApi = new TemplateApi(client);
        webhookApi = new WebhookApi(client);
        subaccountApi = new SubaccountApi(client);
        inboundApi = new InboundApi(client);
        exportApi = new ExportApi(client);
        ipApi = new IpApi(client);
        metadataApi = new MetadataApi(client);
    }
    
    public UserApi users() {
        return userApi;
    }

    public MessageApi messages() {
        return messageApi;
    }

    public TagApi tags(){
        return tagApi;
    }
    
    public RejectApi rejects(){
        return rejectApi;
    }
    
    public WhitelistApi whitelists(){
        return whitelistApi;
    }
    
    public SenderApi senders(){
        return senderApi;
    }
    
    public UrlApi urls(){
        return urlApi;
    }
    
    public TemplateApi templates(){
        return templateApi;
    }
    
    public WebhookApi webhooks(){
        return webhookApi;
    }
    
    public SubaccountApi subacccounts(){
        return subaccountApi;
    }
    
    public InboundApi inbound(){
        return inboundApi;
    }
    
    public ExportApi exports(){
        return exportApi;
    }
    
    public IpApi ips(){
        return ipApi;
    }
    
    public MetadataApi metadata(){
        return metadataApi;
    }
}
