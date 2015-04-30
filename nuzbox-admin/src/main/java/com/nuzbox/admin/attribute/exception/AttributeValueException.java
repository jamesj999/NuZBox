package com.nuzbox.admin.attribute.exception;

/**
 * Created by Jamesjohnstone on 30/04/15.
 */
public class AttributeValueException extends AttributeException {

    public AttributeValueException(String message) {
        super(message);
    }

    public AttributeValueException(Throwable cause) {
        super(cause);
    }

    public AttributeValueException(String message, Throwable cause) {
        super(cause);
    }
}
