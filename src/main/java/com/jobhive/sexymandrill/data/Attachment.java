package com.jobhive.sexymandrill.data;

/**
 * 
 * @author Hussachai
 *
 */
public class Attachment {

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
