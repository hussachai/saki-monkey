package com.jobhive.sexymandrill.api.async;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.Defaults;
import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.Message;
import com.jobhive.sexymandrill.data.TemplateContent;
import com.jobhive.sexymandrill.data.param.MessageSearchParams;
import com.jobhive.sexymandrill.data.param.MessageSendRawParams;
import com.jobhive.sexymandrill.data.response.MessageContent;
import com.jobhive.sexymandrill.data.response.MessageInfo;
import com.jobhive.sexymandrill.data.response.MessageStatus;
import com.jobhive.sexymandrill.data.response.ParsedMessageContent;
import com.jobhive.sexymandrill.data.response.ScheduledInfo;
import com.jobhive.sexymandrill.data.response.TimedSummaryInfo;
import com.jobhive.sexymandrill.utils.Literal;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageAsyncApi extends MandrillAsyncApi {

    public MessageAsyncApi(MandrillAsyncClient client) {
        super(client);
    }

    public Future<HttpResponse> send(Message message, Boolean async,
            String ipPool, Date sendAt, ObjectResponseCallback<MessageStatus[]> callback) {
        Map<String, Object> params = mapParams("message", message)
                .p("async", async).p("ip_pool", ipPool)
                .p("send_at", Defaults.formatDateTime(sendAt));
        return getClient().execute("/messages/send.json", params, callback);
    }

    public Future<HttpResponse> send(Message message,
            ObjectResponseCallback<MessageStatus[]> callback) {
        // sendAt = null (send immediately)
        return send(message, null, null, null, callback);
    }

    public Future<HttpResponse> sendTemplate(String templateName,
            List<TemplateContent> templateContents, Message message,
            Boolean async, String ipPool, Date sendAt,
            ObjectResponseCallback<MessageStatus[]> callback) {
        /* TemplateContent is required field even we don't need it */
        if(templateContents == null){
            templateContents = Literal.list(new TemplateContent("N", "O"));
        }
        Map<String, Object> params = mapParams("template_name", templateName)
                .p("template_content", templateContents).p("message", message)
                .p("async", async).p("ip_pool", ipPool)
                .p("send_at", Defaults.formatDateTime(sendAt));
        return getClient().execute("/messages/send-template.json", params,
                callback);
    }
    
    public Future<HttpResponse> sendTemplate(String templateName, Message message,
            ObjectResponseCallback<MessageStatus[]> callback) {
        return sendTemplate(templateName, null, message, null, null, null, callback);
    }
    
    public Future<HttpResponse> search(MessageSearchParams searchCriteria,
            ObjectResponseCallback<MessageStatus[]> callback) {
        return getClient().execute("/messages/search.json", searchCriteria, callback);
    }
    
    public Future<HttpResponse> searchTimeSeries(
            MessageSearchParams searchCriteria,
            ObjectResponseCallback<TimedSummaryInfo[]> callback) {
        return getClient().execute("/messages/search-time-series.json", searchCriteria,
                callback);
    }

    public Future<HttpResponse> info(String id,
            ObjectResponseCallback<MessageInfo> callback) {
        return getClient().execute("/messages/info.json", 
                mapParams("id", id), callback);
    }
    
    public Future<HttpResponse> content(String id,
            ObjectResponseCallback<MessageContent> callback) {
        return getClient().execute("/messages/content.json", 
                mapParams("id", id), callback);
    }

    public Future<HttpResponse> parse(String rawMessage,
            ObjectResponseCallback<ParsedMessageContent> callback) {
        return getClient().execute("/messages/parse.json", 
                mapParams("raw_message", rawMessage), callback);
    }

    public Future<HttpResponse> sendRaw(MessageSendRawParams rawMessage,
            ObjectResponseCallback<MessageStatus[]> callback) {
        return getClient().execute("/messages/send-raw.json", rawMessage, callback);
    }
    
    public Future<HttpResponse> listScheduled(String toEmail,
            ObjectResponseCallback<ScheduledInfo[]> callback) {
        return getClient().execute("/messages/list-scheduled.json", 
                mapParams("to", toEmail), callback);
    }
    
    public Future<HttpResponse> cancelScheduled(String id,
            ObjectResponseCallback<ScheduledInfo> callback) {
        return getClient().execute("/messages/cancel-scheduled.json", 
                mapParams("id", id), callback);
    }

    public Future<HttpResponse> rescheduled(String id, Date sendAt,
            ObjectResponseCallback<ScheduledInfo> callback) {
        Map<String, Object> params = mapParams("id", id)
                .p("send_at", Defaults.formatDateTime(sendAt));
        return getClient().execute("/messages/rescheduled.json", params,
                callback);
    }
}
