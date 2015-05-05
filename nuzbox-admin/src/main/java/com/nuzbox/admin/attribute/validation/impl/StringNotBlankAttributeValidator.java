package com.nuzbox.admin.attribute.validation.impl;

import com.nuzbox.admin.attribute.exception.AttributeValidationException;
import com.nuzbox.admin.attribute.validation.AttributeValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Jamesjohnstone on 05/05/15.
 */
public class StringNotBlankAttributeValidator extends AttributeValidator {

    public StringNotBlankAttributeValidator(String code) {
        super(code, String.class);
    }

    @Override
    public void validate(Object value) throws AttributeValidationException {
        if(StringUtils.isBlank(value.toString())) {
            throw new AttributeValidationException("Value cannot be blank.");
        }
    }
}
