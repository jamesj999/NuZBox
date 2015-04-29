package com.nuzbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Farrell on 29/04/2015.
 */
@Entity
public class Category extends BaseVersionedModel {

    @GeneratedValue
    @Id
    private Integer identity;

    public Integer getIdentity() {
        return identity;
    }

    //TODO all the shit
}
