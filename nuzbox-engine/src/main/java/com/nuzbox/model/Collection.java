package com.nuzbox.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Farrell on 22/04/2015.
 */
@Entity
public class Collection extends BaseModel {

    @GeneratedValue @Id
    private Integer identity;

    @Column
    private String subject;

    @Column
    private Date date;

    //@Column
    //private Group group;

    @Type(type="com.nuzbox.persistence.types.PaddedStringType")
    @Column(length = 255)
    private Character[] hash;

    @Column
    private Date dateAdded;

    @Column
    @OneToOne
    private Release release;

    @OneToMany
    private Set<CollectionCrossposts> crossposts;

}
