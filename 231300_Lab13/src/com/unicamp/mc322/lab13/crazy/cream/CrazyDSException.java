package com.unicamp.mc322.lab13.crazy.cream;

public class CrazyDSException extends IllegalArgumentException {
    public CrazyDSException() {
    }

    public CrazyDSException(String s) {
        super(s);
    }

    public CrazyDSException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrazyDSException(Throwable cause) {
        super(cause);
    }
}
