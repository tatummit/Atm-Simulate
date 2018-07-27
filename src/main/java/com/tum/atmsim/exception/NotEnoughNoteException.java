package com.tum.atmsim.exception;

public class NotEnoughNoteException extends AtmSimualateException {
    public NotEnoughNoteException() {
    }

    public NotEnoughNoteException(String message) {
        super(message);
    }

    public NotEnoughNoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughNoteException(Throwable cause) {
        super(cause);
    }
}
