package com.jobhive.sakimonkey.utils;

/**
 * 
 * @author Hussachai
 *
 */
public class Assert {

    /**
     * Assert that an object is not null .
     * 
     * @param object
     * @param fieldName
     */
    public static void notNull(Object object, String fieldName) {
        if (object == null) {
            throw new IllegalArgumentException(fieldName + " must not be null");
        }
    }

    /**
     * Assert that the given String is not empty; that is, it must not be null
     * and not the empty String.
     * 
     * @param text
     * @param fieldName
     */
    public static void notEmpty(String text, String fieldName) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException(fieldName + " must not be empty");
        }
    }

}
