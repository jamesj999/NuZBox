package com.nuzbox.admin.attribute.validation;

import com.nuzbox.admin.attribute.exception.AttributeValidationException;

/**
 * Created by Jamesjohnstone on 30/04/15.
 */
public abstract class AttributeValidator {
    protected Class itemType;
    protected String code;

    protected AttributeValidator(String code, Class itemType) {
        this.code = code;
        this.itemType = itemType;
    }

    public Class getItemType() {
        return itemType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public abstract void validate(Object value) throws AttributeValidationException;
}
