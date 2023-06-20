package com.exame.spotfree.exceptions;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
    }

    public EmptyListException(String s, Throwable cause) {
        super(s, cause);
    }

    public EmptyListException(Throwable cause) {
        super(cause);
    }

    public EmptyListException(String s) {
        super(s);
    }
}
