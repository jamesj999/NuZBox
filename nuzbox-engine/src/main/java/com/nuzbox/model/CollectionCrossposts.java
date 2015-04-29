package com.nuzbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Farrell on 29/04/2015.
 */
@Entity
public class CollectionCrossposts extends BaseModel {

    @GeneratedValue
    @Id
    private Long identity;

    @Column
    private Group group;

    @Column
    private Long recordRef;
}
