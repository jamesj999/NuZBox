package com.nuzbox.admin.editors.factory;

import com.nuzbox.admin.editors.AbstractEditor;
import com.nuzbox.model.BaseModel;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jamesjohnstone on 05/05/15.
 */
public abstract class NuzboxEditorFactory {
    private List<AbstractEditor> editors;
    private List<Button> buttons;

    public NuzboxEditorFactory(BaseModel item) {
        editors = generateEditors(item);

        // Move the button generation somewhere sensible
        buttons = new ArrayList<Button>();

        Button saveButton = new Button("Save");
        saveButton.addEventListener(Events.ON_CLICK, new EventListener() {
            @Override
            public void onEvent(Event event) {
                boolean valid = true;
                for (AbstractEditor editor : editors) {
                    valid = editor.validate();
                }
                if(valid) {
                    for (AbstractEditor editor : editors) {
                        valid = editor.save();
                    }
                }
                if(!valid) {
                    Messagebox.show("Error", "Some bad shit went down, yo", Messagebox.OK, Messagebox.ERROR);
                }
            }
        });
        buttons.add(saveButton);
        // Some other oogady boo? I dunno.
    }

    public List<AbstractEditor> getEditors() {
        return editors;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    protected abstract List<AbstractEditor> generateEditors(BaseModel item);
}
