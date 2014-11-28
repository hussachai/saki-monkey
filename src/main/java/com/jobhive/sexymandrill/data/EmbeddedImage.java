package com.jobhive.sexymandrill.data;

/**
 * 
 * @author Hussachai
 *
 */
public class EmbeddedImage extends Attachment {

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
