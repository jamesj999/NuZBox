package com.nuzbox.admin.components;


import com.nuzbox.admin.ApplicationContextProvider;
import com.nuzbox.admin.editors.AbstractEditor;
import com.nuzbox.admin.editors.factory.NuzboxEditorFactory;
import com.nuzbox.admin.editors.factory.NuzboxEditorFactoryResolver;
import com.nuzbox.model.CronJob;
import com.nuzbox.model.service.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zul.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Jamesjohnstone on 29/04/15.
 */
public class NuzboxAdminFramework extends Window {
    @Autowired
    private ModelService modelService;

    private static final Logger LOG = Logger.getLogger(NuzboxAdminFramework.class);

    public NuzboxAdminFramework() {
        if (modelService == null) {
            LOG.error("modelService is null");
        }

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

        CronJob testJob = new CronJob();
        testJob.setTestAttribute("Testing123");

        NuzboxEditorFactory factory = NuzboxEditorFactoryResolver.resolveFactoryForItem(testJob);

        Vbox layout = new Vbox();
        centre.appendChild(layout);

        if (factory != null) {
            for (AbstractEditor editor : factory.getEditors()) {
                layout.appendChild(editor);
            }
            for(Button button : factory.getButtons()) {
                layout.appendChild(button);
            }
        }

        return centre;
    }
}
