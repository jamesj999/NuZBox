package com.nuzbox.admin.editors.impl;

import com.nuzbox.admin.attribute.AttributeProperty;
import com.nuzbox.admin.editors.AbstractEditor;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Textbox;

/**
 * Created by Jamesjohnstone on 01/05/15.
 */
public class TextEditor extends AbstractEditor {
    private static final Logger LOG = Logger.getLogger(TextEditor.class);

    public TextEditor(AttributeProperty attributeProperty) {
        super(attributeProperty);
    }

    @Override
    protected Component getEditorComponent() {
        Textbox textBox = new Textbox();
        return textBox;
    }

    @Override
    protected Object getValue(Component component) {
        if(component instanceof Textbox) {
            return ((Textbox)component).getValue();
        }
        return StringUtils.EMPTY;
    }

    @Override
    protected void setValue(Component component, Object value) {
        if(component instanceof Textbox && value != null) {
            ((Textbox)component).setValue(value.toString());
        }
    }
}
