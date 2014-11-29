package com.jobhive.sakimonkey.exception;

public class InterruptedRuntimeException extends MandrillException {

    private static final long serialVersionUID = 1L;

    public InterruptedRuntimeException(InterruptedException cause) {
        super(cause);
    }

}
