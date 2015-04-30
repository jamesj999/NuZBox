package com.nuzbox.admin.attribute.validation.impl;

import com.nuzbox.admin.attribute.exception.AttributeValidationException;
import com.nuzbox.admin.attribute.validation.AttributeValidator;

/**
 * Created by Jamesjohnstone on 30/04/15.
 */
public class NotNullAttributeValidator extends AttributeValidator {

    public NotNullAttributeValidator(String code) {
        super(code, Object.class);
    }

    @Override
    public void validate(Object value) throws AttributeValidationException {
        if(value == null) {
            throw new AttributeValidationException("Attribute cannot be null");
        }
    }
}
