package com.jobhive.sexymandrill.data;

import java.util.Map;

/**
 * 
 * @author Hussachai
 *
 */
public class RecipientMetaData {

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
