package com.jobhive.sakimonkey.exception;

import java.util.concurrent.ExecutionException;

public class ExecutionRuntimeException extends MandrillException {

    private static final long serialVersionUID = 1L;

    public ExecutionRuntimeException(ExecutionException cause) {
        super(cause);
    }

}
