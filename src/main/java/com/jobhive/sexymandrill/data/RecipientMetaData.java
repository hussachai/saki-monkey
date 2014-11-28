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
