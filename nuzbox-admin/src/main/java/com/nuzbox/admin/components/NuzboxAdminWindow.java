package com.nuzbox.admin.components;


import com.nuzbox.admin.attribute.AttributeProperty;
import com.nuzbox.admin.attribute.exception.AttributeException;
import com.nuzbox.admin.editors.impl.TextEditor;
import com.nuzbox.model.CronJob;
import com.nuzbox.model.service.ModelService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.*;

import java.util.Collections;

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

        AttributeProperty testAttributeAttributeProperty;

        try {
            testAttributeAttributeProperty = new AttributeProperty(new CronJob(), "testAttribute", "Test Attribute", String.class, Collections.EMPTY_LIST);
        } catch(AttributeException e) {
            LOG.error(e);
            return centre;
        }

        TextEditor testAttributeEditor = new TextEditor(testAttributeAttributeProperty);

        centre.appendChild(testAttributeEditor);

        return centre;
    }
}
