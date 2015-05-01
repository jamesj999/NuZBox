package com.nuzbox.admin.editors;

import com.nuzbox.admin.attribute.AttributeProperty;
import com.nuzbox.admin.attribute.exception.AttributeException;
import com.nuzbox.admin.attribute.exception.AttributeValidationException;
import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;

/**
 * Created by Jamesjohnstone on 01/05/15.
 */
public abstract class AbstractEditor extends AbstractComponent implements Editor {
    protected AttributeProperty attributeProperty;
    private Component editorComponent;


    protected Label attributeLabel;

    public AbstractEditor(AttributeProperty attributeProperty) {
        this.attributeProperty = attributeProperty;

        Hbox mainLayout = new Hbox();
        attributeLabel = new Label(attributeProperty.getAttributeName());
        editorComponent = getEditorComponent();

        mainLayout.appendChild(attributeLabel);
        mainLayout.appendChild(editorComponent);

        setValue(editorComponent, attributeProperty.getCurrentValue());

        appendChild(mainLayout);
    }

    public boolean validate() {
        try {
            attributeProperty.validate();
        } catch(AttributeValidationException e) {
            // append e.getMessage() to the component somehow, make it red and shit.
            return false;
        }
        return true;
    }

    public boolean save() {
//        try {
//            attributeProperty.save();
//        } catch(AttributeException e) {
//
//        }
        return true;
    }

    protected abstract Component getEditorComponent();

    protected abstract Object getValue(Component component);

    protected abstract void setValue(Component component, Object value);

    @Override
    public AbstractEditor clone() {
        // TODO: Prolly wanna sort this
        return null;
    }

    @Override
    public String getWidgetClass() {
        return "nuzbox";
    }
}
