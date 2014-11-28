package com.jobhive.sexymandrill.exception;

import java.util.concurrent.TimeoutException;

public class TimeoutRuntimeException extends MandrillException {

    private static final long serialVersionUID = 1L;

    public TimeoutRuntimeException(TimeoutException cause) {
        super(cause);
    }

}
