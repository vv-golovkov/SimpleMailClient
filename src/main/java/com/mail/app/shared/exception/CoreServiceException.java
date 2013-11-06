package com.mail.app.shared.exception;

public class CoreServiceException extends CoreException {
    private static final long serialVersionUID = 402466103248684011L;
    private long errorCode;
    private String message;

    protected CoreServiceException() {
    }

    public CoreServiceException(long errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public CoreServiceException(String message) {
        this.message = message;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
