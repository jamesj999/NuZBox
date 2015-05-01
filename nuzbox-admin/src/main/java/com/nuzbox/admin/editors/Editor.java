package com.nuzbox.admin.editors;

import com.nuzbox.admin.attribute.AttributeProperty;
import com.nuzbox.admin.attribute.exception.AttributeException;
import com.nuzbox.admin.editors.exception.EditorException;

/**
 * Created by Jamesjohnstone on 01/05/15.
 */
public interface Editor {
    //public AttributeProperty getAttributeProperty();

    public boolean validate();

    public boolean save();
}
