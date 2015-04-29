package com.nuzbox.admin.components;


import org.zkoss.zul.*;

/**
 * Created by Jamesjohnstone on 29/04/15.
 */
public class NuzboxAdminWindow extends Window {
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

        Label centreLabel = new Label("Centre");
        centre.appendChild(centreLabel);

        return centre;
    }
}
