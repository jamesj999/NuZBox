package com.nuzbox.admin.attribute.exception;

/**
 * Created by Jamesjohnstone on 30/04/15.
 */
public abstract class AttributeException extends Exception {
    // pass that shit up the chain

    public AttributeException(String message) {
        super(message);
    }

    public AttributeException(Throwable cause) {
        super(cause);
    }

    public AttributeException(String message, Throwable cause) {
        super(cause);
    }

}
