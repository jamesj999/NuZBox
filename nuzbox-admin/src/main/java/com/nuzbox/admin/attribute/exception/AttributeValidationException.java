package com.nuzbox.admin.attribute.exception;

/**
 * Created by Jamesjohnstone on 30/04/15.
 */
public class AttributeValidationException extends AttributeException {

    public AttributeValidationException(String message) {
        super(message);
    }

    public AttributeValidationException(Throwable cause) {
        super(cause);
    }

    public AttributeValidationException(String message, Throwable cause) {
        super(cause);
    }

}
