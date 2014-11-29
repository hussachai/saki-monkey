package com.jobhive.sakimonkey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jobhive.sakimonkey.exception.ParseRuntimException;

/**
 * 
 * @author Hussachai
 *
 */
public final class Defaults {
    
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static final String TIME_ZONE = "GMT";
    
    private static Date parseDate(String value, String format){
        if(value == null) return null;
        try {
            return new SimpleDateFormat(format).parse(value);
        } catch (ParseException e) {
            throw new ParseRuntimException(e);
        }
    }
    
    private static String formatDate(Date date, String format){
        if(date == null) return null;
        return new SimpleDateFormat(format).format(date);
    }
    
    public static Date parseDate(String value){
        return parseDate(value, DATE_FORMAT);
    }
    
    public static Date parseDateTime(String value){
        return parseDate(value, DATETIME_FORMAT);
    }
    
    public static String formatDate(Date date){
        return formatDate(date, DATE_FORMAT);
    }
    
    public static String formatDateTime(Date date){
        return formatDate(date, DATETIME_FORMAT);
    }
    
}
