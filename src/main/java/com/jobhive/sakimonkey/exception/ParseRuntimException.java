package com.jobhive.sakimonkey.exception;

import java.text.ParseException;

public class ParseRuntimException extends MandrillException {
    
    private static final long serialVersionUID = 1L;

    public ParseRuntimException(ParseException cause) {
        super(cause);
    }
    
}
