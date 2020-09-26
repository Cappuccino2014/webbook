package com.wb.webbook.exception;

public class ParamNotNullException extends RuntimeException {

    public ParamNotNullException() {
        super();
    }

    public ParamNotNullException(String message) {
        super(message);
    }

    public ParamNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamNotNullException(Throwable cause) {
        super(cause);
    }

    protected ParamNotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
