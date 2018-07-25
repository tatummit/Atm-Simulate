package com.tum.atmsim.exception;

public class AtmSimualateException extends RuntimeException {

    public AtmSimualateException() {
        super();
    }

    public AtmSimualateException(String message) {
        super(message);
    }

    public AtmSimualateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtmSimualateException(Throwable cause) {
        super(cause);
    }
}
