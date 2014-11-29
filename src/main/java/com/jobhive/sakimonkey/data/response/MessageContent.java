package com.jobhive.sakimonkey.data.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Hussachai
 *
 */
public class MessageContent {

    /**
     * the Unix timestamp from when this message was sent
     */
    @JsonProperty("ts")
    private Integer timestamp;

    /**
     * the message's unique id
     */
    @JsonProperty("_id")
    private String id;

    /**
     * the email address of the sender
     */
    private String fromEmail;

    /**
     * the alias of the sender (if any)
     */
    private String fromName;

    /**
     * the message's subject line
     */
    private String subject;

    /**
     * the message recipient's information
     */
    @JsonProperty("to")
    private Recipient recipient;

    /**
     * list of tags on this message
     */
    private String[] tags;

    /**
     * the key-value pairs of the custom MIME headers for the message's main
     * document
     */
    private Map<String, String> headers;

    /**
     * the text part of the message, if any
     */
    private String text;

    /**
     * the HTML part of the message, if any
     */
    private String html;

    /**
     * an array of any attachments that can be found in the message
     */
    private Attachment[] attachments;

    public Integer getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public String getSubject() {
        return subject;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String[] getTags() {
        return tags;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getText() {
        return text;
    }

    public String getHtml() {
        return html;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    /**
     * 
     * @author Hussachai
     *
     */
    public static class Recipient {

        /**
         * the email address of the recipient
         */
        private String email;

        /**
         * the alias of the recipient (if any)
         */
        private String name;

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 
     * @author Hussachai
     *
     */
    public static class Attachment {

        /**
         * the file name of the attachment
         */
        private String name;

        /**
         * the MIME type of the attachment
         */
        private String type;

        /**
         * the content of the attachment as a base64 encoded string
         */
        private String content;

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getContent() {
            return content;
        }
    }
}
