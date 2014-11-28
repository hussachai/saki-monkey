package com.jobhive.sexymandrill.exception;

public class InterruptedRuntimeException extends MandrillException {

    private static final long serialVersionUID = 1L;

    public InterruptedRuntimeException(InterruptedException cause) {
        super(cause);
    }

}
