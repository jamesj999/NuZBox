package com.nuzbox.admin.components;


import org.zkoss.zk.ui.Component;
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

        testAttributeRow.setParent(rows);
        anotherTestAttributeRow.setParent(rows);

        Label testAttributeLabel = new Label("Test Attribute");
        Label anotherTestAttributeLabel = new Label("Another Test Attribute");

        Textbox testAttributeTextbox = new Textbox();
        Textbox anotherTestAttributeTextbox = new Textbox();

        testAttributeRow.appendChild(testAttributeLabel);
        testAttributeRow.appendChild(testAttributeTextbox);

        anotherTestAttributeRow.appendChild(anotherTestAttributeLabel);
        anotherTestAttributeRow.appendChild(anotherTestAttributeTextbox);

        form.appendChild(columns);
        form.appendChild(rows);

        centre.appendChild(form);

        return centre;
    }
}
