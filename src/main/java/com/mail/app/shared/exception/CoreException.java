package com.mail.app.shared.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Application exception.
 */
public class CoreException extends Exception implements IsSerializable {
    private static final long serialVersionUID = 3006271041328618856L;
    protected long errorCode;

    /**
     * Default constructor. Required by GWT RPC.
     */
    protected CoreException() {
    }

    /**
     * Construct {@link CoreException} object.
     * 
     * @param errorCode
     *            - error code.
     * @param message
     *            - current message.
     */
    public CoreException(final long errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CoreException(final String message) {
        super(message);
    }

    public CoreException(final Throwable e) {
        super(e);
    }

    public CoreException(final String message, final Throwable e) {
        super(message, e);
    }

    public long getErrorCode() {
        return errorCode;
    }
}
