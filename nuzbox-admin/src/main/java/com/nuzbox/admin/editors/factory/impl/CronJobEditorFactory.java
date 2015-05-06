package com.nuzbox.admin.editors.factory.impl;

import com.nuzbox.admin.attribute.AttributeProperty;
import com.nuzbox.admin.attribute.exception.AttributeException;
import com.nuzbox.admin.attribute.validation.AttributeValidator;
import com.nuzbox.admin.attribute.validation.impl.StringNotBlankAttributeValidator;
import com.nuzbox.admin.editors.AbstractEditor;
import com.nuzbox.admin.editors.factory.NuzboxEditorFactory;
import com.nuzbox.admin.editors.impl.TextEditor;
import com.nuzbox.model.BaseModel;
import com.nuzbox.model.CronJob;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jamesjohnstone on 05/05/15.
 */
public class CronJobEditorFactory extends NuzboxEditorFactory {

    private static final Logger LOG = Logger.getLogger(CronJobEditorFactory.class);

    public CronJobEditorFactory(CronJob item) {
        super(item);
    }

    @Override
    protected List<AbstractEditor> generateEditors(BaseModel item) {
        List<AbstractEditor> editors = new ArrayList<AbstractEditor>();

        List<AttributeValidator> testAttributeValidators = new ArrayList<AttributeValidator>();
        testAttributeValidators.add(new StringNotBlankAttributeValidator("testAttributeNotBlank"));

        AttributeProperty testAttributeAttributeProperty;
        AttributeProperty anotherTestAttributeAttributeProperty;

        try {
            testAttributeAttributeProperty = new AttributeProperty(item, "testAttribute", "Test123 Attribute", String.class, testAttributeValidators);
            anotherTestAttributeAttributeProperty = new AttributeProperty(item, "anotherTestAttribute", "Another Test Attribute", String.class, null);
        } catch(AttributeException e) {
            // lol i duno bruv
            LOG.error(e);
            return editors;
        }

        TextEditor testAttributeEditor = new TextEditor(testAttributeAttributeProperty);
        TextEditor anotherTestAttributeEditor = new TextEditor(anotherTestAttributeAttributeProperty);

        editors.add(testAttributeEditor);
        editors.add(anotherTestAttributeEditor);

        return editors;
    }
}
