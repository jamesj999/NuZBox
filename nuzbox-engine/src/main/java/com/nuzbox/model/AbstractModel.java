package com.nuzbox.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 22/04/15.
 */
public abstract class AbstractModel implements Serializable{

    public String getId() {
        // TODO: Some Hibernate/SQL Magic to get the shit
        return StringUtils.EMPTY;
    }

    public void setId() {
        //TODO some magic freaky shit
    }
}
