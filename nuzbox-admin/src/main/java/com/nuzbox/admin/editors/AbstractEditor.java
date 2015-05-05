package com.nuzbox.admin.editors;

import com.nuzbox.admin.attribute.AttributeProperty;
import com.nuzbox.admin.attribute.exception.AttributeException;
import com.nuzbox.admin.attribute.exception.AttributeValidationException;
import org.apache.log4j.Logger;
import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;

/**
 * Created by Jamesjohnstone on 01/05/15.
 */
public abstract class AbstractEditor extends Hbox {

    private static final Logger LOG = Logger.getLogger(AbstractEditor.class);

    protected AttributeProperty attributeProperty;
    private Component editorComponent;


    protected Label attributeLabel;

    public AbstractEditor(AttributeProperty attributeProperty) {
        this.attributeProperty = attributeProperty;

        attributeLabel = new Label(attributeProperty.getAttributeName());
        editorComponent = getEditorComponent();

        editorComponent.addEventListener(getChangeEvent(), getItemUpdateListener(editorComponent));

        appendChild(attributeLabel);
        appendChild(editorComponent);

        setValue(editorComponent, attributeProperty.getCurrentValue());
    }

    public boolean validate() {
        LOG.info("Validate called - " + attributeProperty.getAttributeName());
        try {
            attributeProperty.validate();
        } catch (AttributeValidationException e) {
            // append e.getMessage() to the component somehow, make it red and shit.
            LOG.error("Could not validate " + attributeProperty.getAttributeName() + ": " + e);
            return false;
        }
        return true;
    }

    public boolean save() {
        LOG.info("Save called - " + attributeProperty.getAttributeName());
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

    /**
     * Override this if you need to
     *
     * @return
     */
    protected String getChangeEvent() {
        return Events.ON_CHANGE;
    }

    protected EventListener getItemUpdateListener(final Component component) {
        return new EventListener() {
            @Override
            public void onEvent(Event event) {
                attributeProperty.setCurrentValue(getValue(component));
            }
        };
    }
}
