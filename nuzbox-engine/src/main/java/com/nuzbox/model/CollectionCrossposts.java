package com.nuzbox.model;

import javax.persistence.*;

/**
 * Created by Farrell on 29/04/2015.
 */
@Entity
public class CollectionCrossposts extends BaseModel {

    @GeneratedValue
    @Id
    private Long identity;


    @ManyToOne
    private Collection collection;

    @ManyToOne
    private Group group;

    @Column
    private Long recordRef;

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getRecordRef() {
        return recordRef;
    }

    public void setRecordRef(Long recordRef) {
        this.recordRef = recordRef;
    }
}
