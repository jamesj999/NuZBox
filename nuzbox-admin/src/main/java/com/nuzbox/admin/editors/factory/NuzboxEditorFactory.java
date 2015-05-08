package com.nuzbox.admin.editors.factory;

import com.nuzbox.admin.editors.AbstractEditor;
import com.nuzbox.model.BaseModel;
import org.apache.log4j.Logger;
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

    private static final Logger LOG = Logger.getLogger(NuzboxEditorFactory.class);

    private List<AbstractEditor> editors;
    private List<Button> buttons;

    public NuzboxEditorFactory(BaseModel item) {
        editors = generateEditors(item);
        buttons = generateButtons();

        // Some other oogady boo? I dunno.
    }

    public List<AbstractEditor> getEditors() {
        return editors;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    /**
     * This method will automagically generate a save button for the editors.
     * By all means override it to produce new buttons - you'll need to put their event listeners on too.
     * @return
     */
    protected List<Button> generateButtons() {
        List<Button> output = new ArrayList<Button>();

        Button saveButton = new Button("Save");
        saveButton.addEventListener(Events.ON_CLICK, new EventListener() {
            @Override
            public void onEvent(Event event) {
                boolean valid = true;
                for (AbstractEditor editor : editors) {
                    if(!editor.validate()) {
                        valid = false;
                    }
                }
                if (valid) {
                    for (AbstractEditor editor : editors) {
                        valid = editor.save();
                    }
                }
                if (!valid) {
                    Messagebox.show("Some bad shit went down, yo", "Error", Messagebox.OK, Messagebox.ERROR);
                }
            }
        });
        output.add(saveButton);

        return output;
    }

    protected abstract List<AbstractEditor> generateEditors(BaseModel item);
}
