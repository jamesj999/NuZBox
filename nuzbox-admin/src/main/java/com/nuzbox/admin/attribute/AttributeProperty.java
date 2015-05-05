package com.nuzbox.admin.attribute;

import com.nuzbox.admin.attribute.exception.AttributeException;
import com.nuzbox.admin.attribute.exception.AttributeValidationException;
import com.nuzbox.admin.attribute.exception.AttributeValidatorTypeException;
import com.nuzbox.admin.attribute.exception.AttributeValueException;
import com.nuzbox.admin.attribute.validation.AttributeValidator;
import com.nuzbox.model.BaseModel;
import com.nuzbox.model.service.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jamesjohnstone on 30/04/15.
 */
public class AttributeProperty {
    @Autowired
    private ModelService modelService;

    protected BaseModel item;
    protected String attributeQualifier;
    protected String attributeName;
    protected Class attributeClass;
    protected List<AttributeValidator> validators;
    protected Object currentValue;
    protected Object originalValue;

    private static final Logger LOG = Logger.getLogger(AttributeProperty.class);

    public AttributeProperty(BaseModel item, String attributeQualifier, String attributeName, Class attributeClass, List<AttributeValidator> validators) throws AttributeException {
        this.item = item;
        this.attributeQualifier = attributeQualifier;
        this.attributeName = attributeName;
        // Unfortunately, we can't ascertain the attribute class if it is currently null
        this.attributeClass = attributeClass;
        this.validators = (validators == null) ? Collections.EMPTY_LIST : validators;

        validateValidators();
        currentValue = getCurrentValueFromItem();
        originalValue = getCurrentValueFromItem();
    }

    protected Object getCurrentValueFromItem() throws AttributeValueException {
        String attributeQualifierFirstCapitalised = capitaliseFirstCharacter(attributeQualifier);
        LOG.info("Parsed aq: " + attributeQualifierFirstCapitalised);
        Method method = ReflectionUtils.findMethod(item.getClass(), "get" + attributeQualifierFirstCapitalised);
        if (method == null) {
            throw new AttributeValueException("Cannot find method: get" + attributeQualifierFirstCapitalised + " on Item: " + item);
        }
        // No need to care if it's null - it can be, it just means we can't check that it matches our desired type.
        Object valueFromItem = ReflectionUtils.invokeMethod(method, item);
        if (valueFromItem != null && !attributeClass.equals(valueFromItem.getClass())) {
            return new AttributeValueException("Value from item does not match exptected type - " + attributeClass.getSimpleName() + " and is instead " + valueFromItem.getClass().getSimpleName());
        }

        return valueFromItem;
    }

    protected void setCurrentValueOnItem() throws AttributeValueException {
        String attributeQualifierFirstCapitalised = capitaliseFirstCharacter(attributeQualifier);

        Method method = ReflectionUtils.findMethod(item.getClass(), "set" + attributeQualifierFirstCapitalised, attributeClass);
        if (method == null) {
            throw new AttributeValueException("Cannot find method: set" + attributeQualifierFirstCapitalised + " on Item: " + item);
        }

        // Test this with an incorrect input and see if it throws an exception or wut:
        ReflectionUtils.invokeMethod(method, item, currentValue);
    }

    private String capitaliseFirstCharacter(String input) {
        return input.substring(0, 1).toUpperCase() + attributeQualifier.substring(1);
    }

    public Object getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Object currentValue) {
        this.currentValue = currentValue;
    }

    public String getAttributeName() {
        return attributeName;
    }

    // yo dawg, herd u liek validating
    protected void validateValidators() throws AttributeValidatorTypeException {
        for (AttributeValidator validator : validators) {
            if (!validator.getItemType().isAssignableFrom(attributeClass)) {
                throw new AttributeValidatorTypeException("Validator " + validator.getCode() + "'s item type does not match the item type of this attribute property.");
            }
        }
    }

    public void validate() throws AttributeValidationException {
        for (AttributeValidator validator : validators) {
            validator.validate(currentValue);
        }
    }

    public void save() throws AttributeValueException {
        setCurrentValueOnItem();
        save();
        // Use the model service to save the attribute...
    }
}
