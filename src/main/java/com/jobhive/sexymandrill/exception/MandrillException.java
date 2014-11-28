package com.jobhive.sexymandrill.exception;

public class MandrillException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MandrillException() {
        super();
    }

    public MandrillException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MandrillException(String message, Throwable cause) {
        super(message, cause);
    }

    public MandrillException(String message) {
        super(message);
    }

    public MandrillException(Throwable cause) {
        super(cause);
    }

}
