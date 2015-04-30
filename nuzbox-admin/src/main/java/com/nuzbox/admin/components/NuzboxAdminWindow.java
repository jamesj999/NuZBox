package com.nuzbox.admin.components;


import com.nuzbox.model.service.ModelService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.*;

/**
 * Created by Jamesjohnstone on 29/04/15.
 */
public class NuzboxAdminWindow extends Window {
    @Autowired
    private ModelService modelService;

    private static final Logger LOG = Logger.getLogger(NuzboxAdminWindow.class);

    public NuzboxAdminWindow() {
        setHeight("100%");
        setWidth("100%");
        setVisible(true);

        Borderlayout layout = new Borderlayout();

        layout.appendChild(generateNorth());
        layout.appendChild(generateWest());
        layout.appendChild(generateCenter());

        appendChild(layout);
    }

    private North generateNorth() {
        North north = new North();

        Label northLabel = new Label("North");
        north.appendChild(northLabel);

        return north;
    }

    private West generateWest() {
        West west = new West();

        Label westLabel = new Label("West");
        west.appendChild(westLabel);

        return west;
    }

    private Center generateCenter() {
        Center centre = new Center();

        Vbox formBox = new Vbox();

        Grid form = new Grid();
        form.setWidth("30%");

        Columns columns = new Columns();
        Column attribute = new Column("Attribute");
        Column value = new Column("Value");

        attribute.setParent(columns);
        value.setParent(columns);

        Rows rows = new Rows();
        Row testAttributeRow = new Row();
        Row anotherTestAttributeRow = new Row();
        Row buttonRow = new Row();

        testAttributeRow.setParent(rows);
        anotherTestAttributeRow.setParent(rows);
        buttonRow.setParent(rows);

        Label testAttributeLabel = new Label("Test Attribute");
        final Label anotherTestAttributeLabel = new Label("Another Test Attribute");
        final Label anotherTestAttributeErrorLabel = new Label();
        Textbox testAttributeTextbox = new Textbox();
        final Textbox anotherTestAttributeTextbox = new Textbox();
        final Button submitButton = new Button("Submit");

        testAttributeRow.appendChild(testAttributeLabel);
        testAttributeRow.appendChild(testAttributeTextbox);

        anotherTestAttributeRow.appendChild(anotherTestAttributeLabel);
        anotherTestAttributeRow.appendChild(anotherTestAttributeTextbox);
        anotherTestAttributeRow.appendChild(anotherTestAttributeErrorLabel);

        buttonRow.appendChild(submitButton);

        anotherTestAttributeTextbox.addEventListener(Events.ON_CHANGE, new EventListener() {
            @Override
            public void onEvent(Event event) {
                if (StringUtils.isBlank(anotherTestAttributeTextbox.getValue())) {
                    anotherTestAttributeErrorLabel.setValue("This attribute cannot be null breh");
                    anotherTestAttributeErrorLabel.setVisible(true);
                } else {
                    anotherTestAttributeErrorLabel.setVisible(false);
                }
            }
        });

        submitButton.addEventListener(Events.ON_CLICK, new EventListener() {
            @Override
            public void onEvent(Event event) {
                if (modelService == null) {
                    LOG.error("Shit");
                }
                // Shite, now we need the modelservice... brb, adding spring.
            }
        });

        form.appendChild(columns);
        form.appendChild(rows);

        centre.appendChild(form);

        return centre;
    }
}
