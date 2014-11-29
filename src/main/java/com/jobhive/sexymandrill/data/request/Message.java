package com.jobhive.sexymandrill.data.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhive.sexymandrill.utils.Assert;
import com.jobhive.sexymandrill.utils.Literal;

/**
 * the information on the message to send
 * 
 * @author Hussachai
 *
 */
public class Message {

    /**
     * the full HTML content to be sent
     */
    private String html;

    /**
     * optional full text content to be sent
     */
    private String text;

    /**
     * the message subject
     */
    private String subject;

    /**
     * the sender email address
     */
    private String fromEmail;

    /**
     * optional from name to be used
     */
    private String fromName;

    /**
     * an array of recipient information.
     */
    @JsonProperty("to")
    private Set<Recipient> recipients;

    /**
     * optional extra headers to add to the message (most headers are allowed)
     */
    private Map<String, String> headers;

    /**
     * whether or not this message is important, and should be delivered ahead
     * of non-important messages
     */
    private Boolean important;

    /**
     * whether or not to turn on open tracking for the message
     */
    private Boolean trackOpens;

    /**
     * whether or not to turn on click tracking for the message
     */
    private Boolean trackClicks;

    /**
     * whether or not to automatically generate a text part for messages that
     * are not given text
     */
    private Boolean autoText;

    /**
     * whether or not to automatically generate an HTML part for messages that
     * are not given HTML
     */
    private Boolean autoHtml;

    /**
     * whether or not to automatically inline all CSS styles provided in the
     * message HTML - only for HTML documents less than 256KB in size
     */
    private Boolean inlineCss;

    /**
     * whether or not to strip the query string from URLs when aggregating
     * tracked URL data
     */
    private Boolean urlStripQs;

    /**
     * whether or not to expose all recipients in to "To" header for each email
     */
    private Boolean preserveRecipients;

    /**
     * set to false to remove content logging for sensitive emails
     */
    private Boolean viewContentLink;

    /**
     * an optional address to receive an exact copy of each recipient's email
     * email
     */
    private String bccAddress;

    /**
     * a custom domain to use for tracking opens and clicks instead of
     * mandrillapp.com
     */
    private String trackingDomain;

    /**
     * a custom domain to use for SPF/DKIM signing instead of mandrill (for
     * "via" or "on behalf of" in email clients)
     */
    private String signingDomain;

    /**
     * a custom domain to use for the messages's return-path
     */
    private String returnPathDomain;

    /**
     * whether to evaluate merge tags in the message. Will automatically be set
     * to true if either merge_vars or global_merge_vars are provided.
     */
    private Boolean merge;

    /**
     * the merge tag language to use when evaluating merge tags, either
     * mailchimp or handlebars oneof(mailchimp, handlebars)
     */
    private MergeLanguage mergeLanguage = MergeLanguage.Handlebars;

    /**
     * global merge variables to use for all recipients. You can override these
     * per recipient.
     */
    @JsonProperty("global_merge_vars")
    private Set<Var> globalVars;

    /**
     * per-recipient merge variables, which override global merge variables with
     * the same name.
     */
    @JsonProperty("merge_vars")
    private Set<RecipientVars> recipientVars;

    /**
     * an array of string to tag the message with. Stats are accumulated using
     * tags, though we only store the first 100 we see, so this should not be
     * unique or change frequently. Tags should be 50 characters or less. Any
     * tags starting with an underscore are reserved for internal use and will
     * cause errors.
     * 
     * a single tag - must not start with an underscore
     */
    private Set<String> tags;

    /**
     * the unique id of a subaccount for this message - must already exist or
     * will fail with an error
     */
    private String subaccount;

    /**
     * an array of strings indicating for which any matching URLs will
     * automatically have Google Analytics parameters appended to their query
     * string automatically.
     */
    private Set<String> googleAnalyticsDomains;

    /**
     * optional string indicating the value to set for the utm_campaign tracking
     * parameter. If this isn't provided the email's from address will be used
     * instead.
     */
    private String googleAnalyticsCampaign;

    /**
     * metadata an associative array of user metadata. Mandrill will store this
     * metadata and make it available for retrieval. In addition, you can select
     * up to 10 metadata fields to index and make searchable using the Mandrill
     * search api.
     */
    private Map<String, String> metadata;

    /**
     * Per-recipient metadata that will override the global values specified in
     * the metadata parameter.
     */
    private Set<RecipientMetaData> recipientMetadata;

    /**
     * an array of supported attachments to add to the message
     */
    private Set<Attachment> attachments;

    /**
     * an array of embedded images to add to the message
     */
    private Set<EmbeddedImage> images;

    public String getHtml() {
        return html;
    }

    public Message setHtml(String html) {
        this.html = html;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Message setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public Message setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public Message setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public Set<Recipient> getRecipients() {
        return recipients;
    }

    public Message setRecipients(Set<Recipient> recipients) {
        this.recipients = recipients;
        if (recipients != null) {
            this.recipientVars = new HashSet<>();
            for (Recipient recipient : recipients) {
                this.recipientVars.add(new RecipientVars(recipient.getEmail(),
                        recipient.getVars()));
            }
        }
        return this;
    }

    public Message addRecipient(Recipient recipient) {
        Assert.notNull(recipient, "recipient");
        if (this.recipients == null) {
            this.recipients = new HashSet<>();
            this.recipientVars = new HashSet<>();
        }
        this.recipients.add(recipient);
        this.recipientVars.add(new RecipientVars(recipient.getEmail(),
                recipient.getVars()));
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Message setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public Message addHeader(String name, String value) {
        Assert.notNull(name, "name");
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
        this.headers.put(name, value);
        return this;
    }

    public Boolean getImportant() {
        return important;
    }

    public Message setImportant(Boolean important) {
        this.important = important;
        return this;
    }

    public Boolean getTrackOpens() {
        return trackOpens;
    }

    public Message setTrackOpens(Boolean trackOpens) {
        this.trackOpens = trackOpens;
        return this;
    }

    public Boolean getTrackClicks() {
        return trackClicks;
    }

    public Message setTrackClicks(Boolean trackClicks) {
        this.trackClicks = trackClicks;
        return this;
    }

    public Boolean getAutoText() {
        return autoText;
    }

    public Message setAutoText(Boolean autoText) {
        this.autoText = autoText;
        return this;
    }

    public Boolean getAutoHtml() {
        return autoHtml;
    }

    public Message setAutoHtml(Boolean autoHtml) {
        this.autoHtml = autoHtml;
        return this;
    }

    public Boolean getInlineCss() {
        return inlineCss;
    }

    public Message setInlineCss(Boolean inlineCss) {
        this.inlineCss = inlineCss;
        return this;
    }

    public Boolean getUrlStripQs() {
        return urlStripQs;
    }

    public Message setUrlStripQs(Boolean urlStripQs) {
        this.urlStripQs = urlStripQs;
        return this;
    }

    public Boolean getPreserveRecipients() {
        return preserveRecipients;
    }

    public Message setPreserveRecipients(Boolean preserveRecipients) {
        this.preserveRecipients = preserveRecipients;
        return this;
    }

    public Boolean getViewContentLink() {
        return viewContentLink;
    }

    public Message setViewContentLink(Boolean viewContentLink) {
        this.viewContentLink = viewContentLink;
        return this;
    }

    public String getBccAddress() {
        return bccAddress;
    }

    public Message setBccAddress(String bccAddress) {
        this.bccAddress = bccAddress;
        return this;
    }

    public String getTrackingDomain() {
        return trackingDomain;
    }

    public Message setTrackingDomain(String trackingDomain) {
        this.trackingDomain = trackingDomain;
        return this;
    }

    public String getSigningDomain() {
        return signingDomain;
    }

    public Message setSigningDomain(String signingDomain) {
        this.signingDomain = signingDomain;
        return this;
    }

    public String getReturnPathDomain() {
        return returnPathDomain;
    }

    public Message setReturnPathDomain(String returnPathDomain) {
        this.returnPathDomain = returnPathDomain;
        return this;
    }

    public Boolean getMerge() {
        return merge;
    }

    public Message setMerge(Boolean merge) {
        this.merge = merge;
        return this;
    }

    public MergeLanguage getMergeLanguage() {
        return mergeLanguage;
    }

    public Message setMergeLanguage(MergeLanguage mergeLanguage) {
        this.mergeLanguage = mergeLanguage;
        return this;
    }

    public Set<Var> getGlobalVars() {
        return globalVars;
    }

    public Message setGlobalVars(Set<Var> globalVars) {
        this.globalVars = globalVars;
        return this;
    }

    public Message addGlobalVar(Var globalVar) {
        Assert.notNull(globalVar, "globalVar");
        if (this.globalVars == null) {
            this.globalVars = new HashSet<>();
        }
        this.globalVars.add(globalVar);
        return this;
    }

    public Set<String> getTags() {
        return tags;
    }

    public Message setTags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public Message setTags(String... tags) {
        if (tags != null) {
            this.tags = new HashSet<String>();
            for (String tag : tags) {
                this.tags.add(tag);
            }
        }
        return this;
    }

    public String getSubaccount() {
        return subaccount;
    }

    public Message setSubaccount(String subaccount) {
        this.subaccount = subaccount;
        return this;
    }

    public Set<String> getGoogleAnalyticsDomains() {
        return googleAnalyticsDomains;
    }

    public Message setGoogleAnalyticsDomains(Set<String> googleAnalyticsDomains) {
        this.googleAnalyticsDomains = googleAnalyticsDomains;
        return this;
    }

    public Message setGoogleAnalyticsDomains(String... googleAnalyticsDomains) {
        this.googleAnalyticsDomains = Literal.set(googleAnalyticsDomains);
        return this;
    }

    public String getGoogleAnalyticsCampaign() {
        return googleAnalyticsCampaign;
    }

    public Message setGoogleAnalyticsCampaign(String googleAnalyticsCampaign) {
        this.googleAnalyticsCampaign = googleAnalyticsCampaign;
        return this;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public Message setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public Message addMetadata(String name, String value) {
        Assert.notNull(name, "name");
        if (this.metadata == null) {
            this.metadata = new HashMap<>();
        }
        this.metadata.put(name, value);
        return this;
    }

    public Set<RecipientMetaData> getRecipientMetadata() {
        return recipientMetadata;
    }

    public Message setRecipientMetadata(
            Set<RecipientMetaData> recipientMetadata) {
        this.recipientMetadata = recipientMetadata;
        return this;
    }

    public Message addRecipientMetadata(RecipientMetaData recipientMetadata) {
        Assert.notNull(recipientMetadata, "recipientMetadata");
        if (this.recipientMetadata == null) {
            this.recipientMetadata = new HashSet<>();
        }
        this.recipientMetadata.add(recipientMetadata);
        return this;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public Message setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Message addAttachment(Attachment attachment) {
        Assert.notNull(attachment, "attachment");
        if (this.attachments == null) {
            this.attachments = new HashSet<>();
        }
        this.attachments.add(attachment);
        return this;
    }

    public Set<EmbeddedImage> getImages() {
        return images;
    }

    public Message setImages(Set<EmbeddedImage> images) {
        this.images = images;
        return this;
    }

    public Message addImage(EmbeddedImage image) {
        Assert.notNull(image, "image");
        if (this.images == null) {
            this.images = new HashSet<>();
        }
        this.images.add(image);
        return this;
    }

    /**
     * 
     * @author Hussachai
     *
     */
    public enum MergeLanguage {

        MailChimp, Handlebars;

        private String value;

        private MergeLanguage() {
            this.value = name().toLowerCase();
        }
        
        @Override
        public String toString() {
            return value;
        }
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
         * the optional display name to use for the recipient
         */
        private String name;

        /**
         * the header type to use for the recipient, defaults to "to" if not
         * provided oneof(to, cc, bcc)
         */
        private RecipientType type = RecipientType.To;
        
        @JsonIgnore
        private List<Var> vars;

        public Recipient() {
        }

        public Recipient(String email, String name, RecipientType type) {
            setEmail(email);
            setName(name);
            setType(type);
        }

        public Recipient(String email, String name) {
            this(email, name, RecipientType.To);
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((email == null) ? 0 : email.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Recipient other = (Recipient) obj;
            if (email == null) {
                if (other.email != null)
                    return false;
            } else if (!email.equals(other.email))
                return false;
            return true;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Recipient setName(String name) {
            this.name = name;
            return this;
        }

        public RecipientType getType() {
            return type;
        }

        public Recipient setType(RecipientType type) {
            this.type = type;
            return this;
        }

        public List<Var> getVars() {
            return vars;
        }

        public Recipient setVars(List<Var> vars) {
            this.vars = vars;
            return this;
        }

        public Recipient addVar(Var var) {
            Assert.notNull(var, "var");
            if (this.vars == null) {
                this.vars = new ArrayList<>();
            }
            this.vars.add(var);
            return this;
        }

        public Recipient addVar(String name, Object content) {
            Var var = new Var(name, content);
            return addVar(var);
        }
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static enum RecipientType {

        To, CC, BCC;
        
        private String value;
        
        private RecipientType(){
            this.value = name().toLowerCase();
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class RecipientMetaData {

        /**
         * the email address of the recipient that the metadata is associated with
         */
        private String rcpt;

        /**
         * a map containing the recipient's unique metadata. If a key exists in both
         * the per-recipient metadata and the global metadata, the per-recipient
         * metadata will be used.
         */
        private Map<String, String> values;
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((rcpt == null) ? 0 : rcpt.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            RecipientMetaData other = (RecipientMetaData) obj;
            if (rcpt == null) {
                if (other.rcpt != null)
                    return false;
            } else if (!rcpt.equals(other.rcpt))
                return false;
            return true;
        }

        public String getRcpt() {
            return rcpt;
        }

        public void setRcpt(String rcpt) {
            this.rcpt = rcpt;
        }

        public Map<String, String> getValues() {
            return values;
        }

        public void setValues(Map<String, String> values) {
            this.values = values;
        }

    }

    /**
     * 
     * @author Hussachai
     *
     */
    public static class Var {

        /**
         * the merge variable's name. Merge variable names are case-insensitive and
         * may not start with _
         */
        private String name;

        /**
         * the merge variable's content
         */
        private Object content;
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Var other = (Var) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        public Var(String name, Object content) {
            setName(name);
            setContent(content);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

    }
    
    /**
     * Per-recipient merge variables, which override global merge variables with the
     * same name.
     * 
     * @author Hussachai
     *
     */
    public static class RecipientVars {

        /**
         * the email address of the recipient that the merge variables should apply
         * to
         */
        private String rcpt;

        /**
         * the recipient's merge variables
         */
        private List<Var> vars;

        public RecipientVars(String rcpt, List<Var> vars) {
            setRcpt(rcpt);
            setVars(vars);
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((rcpt == null) ? 0 : rcpt.hashCode());
            return result;
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            RecipientVars other = (RecipientVars) obj;
            if (rcpt == null) {
                if (other.rcpt != null)
                    return false;
            } else if (!rcpt.equals(other.rcpt))
                return false;
            return true;
        }


        public String getRcpt() {
            return rcpt;
        }

        public void setRcpt(String rcpt) {
            Assert.notNull(rcpt, "rcpt");
            this.rcpt = rcpt;
        }

        public List<Var> getVars() {
            return vars;
        }

        public void setVars(List<Var> vars) {
            Assert.notNull(vars, "vars");
            this.vars = vars;
        }

        public void setVars(Var... vars) {
            setVars(new ArrayList<Var>(Arrays.asList(vars)));
        }

        public RecipientVars addVar(String name, Object content) {
            if (this.vars == null) {
                this.vars = new ArrayList<Var>();
            }
            this.vars.add(new Var(name, content));
            return this;
        }

    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class Attachment {

        /**
         * the MIME type of the attachment
         */
        private String type;

        /**
         * the file name of the attachment
         */
        private String name;

        /**
         * the content of the attachment as a base64-encoded string
         */
        private String content;
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Attachment other = (Attachment) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }
    
    /**
     * 
     * @author Hussachai
     *
     */
    public static class EmbeddedImage extends Attachment {

        /**
         * the MIME type of the image - must start with "image/"
         */
        @Override
        public void setType(String type) {
            if (type == null || !type.toLowerCase().startsWith("image/")) {
                throw new IllegalArgumentException("type must start with 'image/'");
            }
            super.setType(type);
        }

        /**
         * the Content ID of the image - use <img src="cid:THIS_VALUE"> to reference
         * the image in your HTML content
         */
        @Override
        public void setName(String name) {
            super.setName(name);
        }

    }
}
