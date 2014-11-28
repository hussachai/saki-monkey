package com.jobhive.sexymandrill.exception;

import java.io.IOException;

public class IORuntimeException extends MandrillException {

    private static final long serialVersionUID = 1L;

    public IORuntimeException(IOException cause) {
        super(cause);
    }

}
