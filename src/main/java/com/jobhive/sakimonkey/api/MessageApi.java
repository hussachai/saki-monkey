package com.jobhive.sakimonkey.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jobhive.sakimonkey.Defaults;
import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.request.Message;
import com.jobhive.sakimonkey.data.request.MessageSearchParams;
import com.jobhive.sakimonkey.data.request.MessageSendRawParams;
import com.jobhive.sakimonkey.data.request.TemplateContent;
import com.jobhive.sakimonkey.data.response.MessageContent;
import com.jobhive.sakimonkey.data.response.MessageInfo;
import com.jobhive.sakimonkey.data.response.MessageSchedule;
import com.jobhive.sakimonkey.data.response.MessageStatus;
import com.jobhive.sakimonkey.data.response.ParsedMessageContent;
import com.jobhive.sakimonkey.data.response.TimedStats;
import com.jobhive.sakimonkey.utils.Literal;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageApi extends MandrillApi {

    public MessageApi(MandrillClient client) {
        super(client);
    }

    /**
     * Send a new transactional message through Mandrill
     * @param message
     * @param async enable a background sending mode that is optimized for 
     *        bulk sending. In async mode, messages/send will immediately return 
     *        a status of "queued" for every recipient. To handle rejections 
     *        when sending in async mode, set up a webhook for the 'reject' event. 
     *        Defaults to false for messages with no more than 10 recipients; 
     *        messages with more than 10 recipients are always sent asynchronously, 
     *        regardless of the value of async.
     * @param ipPool the name of the dedicated ip pool that should be used to send 
     *        the message. If you do not have any dedicated IPs, this parameter 
     *        has no effect. If you specify a pool that does not exist, 
     *        your default pool will be used instead.
     * @param sendAt when this message should be sent as a UTC timestamp in 
     *        YYYY-MM-DD HH:MM:SS format. If you specify a time in the past, 
     *        the message will be sent immediately. An additional fee applies 
     *        for scheduled email, and this feature is only available to accounts 
     *        with a positive balance.
     * @return
     */
    public Result<MessageStatus[]> send(Message message, Boolean async,
            String ipPool, Date sendAt) {
        Map<String, Object> params = mapParams("message", message)
                .p("async", async).p("ip_pool", ipPool)
                .p("send_at", Defaults.formatDateTime(sendAt));
        return getClient().execute(MessageStatus[].class, MESSAGE_SEND, params);
    }
    
    /**
     * 
     * @param message
     * @param callback
     * @return
     */
    public Result<MessageStatus[]> send(Message message) {
        // sendAt = null (send immediately)
        return send(message, null, null, null);
    }

    /**
     * Send a new transactional message through Mandrill using a template
     * @param templateName the immutable name or slug of a template that exists in 
     *        the user's account. For backwards-compatibility, the template name 
     *        may also be used but the immutable slug is preferred.
     * @param templateContents an array of template content to send. Each item in 
     *        the array should be a struct with two keys - name: the name of the 
     *        content block to set the content for, and content: the actual content 
     *        to put into the block
     * @param message the other information on the message to send - same as 
     *        /messages/send, but without the html content
     * @param async enable a background sending mode that is optimized for 
     *        bulk sending. In async mode, messages/send will immediately return 
     *        a status of "queued" for every recipient. To handle rejections 
     *        when sending in async mode, set up a webhook for the 'reject' event. 
     *        Defaults to false for messages with no more than 10 recipients; 
     *        messages with more than 10 recipients are always sent asynchronously, 
     *        regardless of the value of async.
     * @param ipPool the name of the dedicated ip pool that should be used to send 
     *        the message. If you do not have any dedicated IPs, this parameter 
     *        has no effect. If you specify a pool that does not exist, 
     *        your default pool will be used instead.
     * @param sendAt when this message should be sent as a UTC timestamp in 
     *        YYYY-MM-DD HH:MM:SS format. If you specify a time in the past, 
     *        the message will be sent immediately. An additional fee applies 
     *        for scheduled email, and this feature is only available to accounts 
     *        with a positive balance.
     * @param callback
     * @return
     */
    public Result<MessageStatus[]> sendTemplate(String templateName,
            List<TemplateContent> templateContents, Message message,
            Boolean async, String ipPool, Date sendAt) {
        /* TemplateContent is required field even we don't need it */
        if(templateContents == null){
            templateContents = Literal.list(new TemplateContent("N", "O"));
        }
        Map<String, Object> params = mapParams("template_name", templateName)
                .p("template_content", templateContents).p("message", message)
                .p("async", async).p("ip_pool", ipPool)
                .p("send_at", Defaults.formatDateTime(sendAt));
        return getClient().execute(MessageStatus[].class,
                MESSAGE_SEND_TEMPLATE, params);
    }
    
    /**
     * 
     * @param templateName
     * @param message
     * @param callback
     * @return
     */
    public Result<MessageStatus[]> sendTemplate(String templateName, Message message) {
        return sendTemplate(templateName, null, message, null, null, null);
    }
    
    /**
     * Search recently sent messages and optionally narrow by date range, tags, 
     * senders, and API keys. If no date range is specified, results within the 
     * last 7 days are returned. This method may be called up to 20 times per minute. 
     * If you need the data more often, you can use /messages/info.json to get 
     * the information for a single message, or webhooks to push activity to your 
     * own application for querying.
     * @param params
     * @param callback
     * @return
     */
    public Result<MessageStatus[]> search(MessageSearchParams params) {
        return getClient().execute(MessageStatus[].class, MESSAGE_SEARCH, params);
    }
    
    /**
     * Search the content of recently sent messages and return the aggregated 
     * hourly stats for matching messages
     * @param params
     * @param callback
     * @return
     */
    public Result<TimedStats[]> searchTimeSeries(MessageSearchParams params) {
        return getClient().execute(TimedStats[].class, 
                MESSAGE_SEARCH_TIME_SERIES, params);
    }

    /**
     * Get the information for a single recently sent message
     * @param id the unique id of the message to get - passed as the "_id" field 
     *        in webhooks, send calls, or search calls
     * @param callback
     * @return
     */
    public Result<MessageInfo> info(String id) {
        return getClient().execute(MessageInfo.class, MESSAGE_INFO, 
                mapParams("id", id));
    }
    
    /**
     * Get the full content of a recently sent message
     * @param id the unique id of the message to get - passed as the "_id" field 
     *        in webhooks, send calls, or search calls
     * @param callback
     * @return
     */
    public Result<MessageContent> content(String id) {
        return getClient().execute(MessageContent.class, 
                MESSAGE_CONTENT, mapParams("id", id));
    }

    /**
     * Parse the full MIME document for an email message, returning the content of 
     * the message broken into its constituent pieces
     * @param rawMessage
     * @param callback
     * @return
     */
    public Result<ParsedMessageContent> parse(String rawMessage) {
        return getClient().execute(ParsedMessageContent.class, 
                MESSAGE_PARSE, mapParams("raw_message", rawMessage));
    }

    /**
     * Take a raw MIME document for a message, and send it exactly as if 
     * it were sent through Mandrill's SMTP servers
     * @param rawMessage
     * @param callback
     * @return
     */
    public Result<MessageStatus[]> sendRaw(MessageSendRawParams rawMessage) {
        return getClient().execute(MessageStatus[].class, 
                MESSAGE_SEND_RAW, rawMessage);
    }
    
    /**
     * Queries your scheduled emails by sender or recipient, or both.
     * @param toEmail an optional recipient address to restrict results to
     * @param callback
     * @return
     */
    public Result<MessageSchedule[]> listScheduled(String toEmail) {
        return getClient().execute(MessageSchedule[].class, 
                MESSAGE_LIST_SCHEDULED, mapParams("to", toEmail));
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Result<MessageSchedule[]> listScheduled() {
        return listScheduled(null);
    }
    
    /**
     * Cancels a scheduled email.
     * @param id
     * @param callback
     * @return
     */
    public Result<MessageSchedule> cancelScheduled(String id) {
        return getClient().execute(MessageSchedule.class, 
                MESSAGE_CANCEL_SCHEDULED, mapParams("id", id));
    }
    
    /**
     * Reschedules a scheduled email.
     * @param id a scheduled email id, as returned by any of the messages/send 
     *        calls or messages/list-scheduled
     * @param sendAt the new UTC timestamp when the message should sent. 
     *        Mandrill can't time travel, so if you specify a time in past the 
     *        message will be sent immediately
     * @param callback
     * @return
     */
    public Result<MessageSchedule> rescheduled(String id, Date sendAt) {
        Map<String, Object> params = mapParams("id", id)
                .p("send_at", Defaults.formatDateTime(sendAt));
        return getClient().execute(MessageSchedule.class, 
                MESSAGE_RESCHEDULED, params);
    }
}
