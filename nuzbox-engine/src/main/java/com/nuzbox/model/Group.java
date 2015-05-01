package com.nuzbox.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Farrell on 29/04/2015.
 */
@Entity
public class Group {
    @GeneratedValue
    @Id
    private Integer identity;

    @Column
    @OneToMany(mappedBy = "group")
    private Set<CollectionCrossposts> crossposts;


    public Integer getIdentity() {
        return identity;
    }
    public Set<CollectionCrossposts> getCrossposts() {
        return crossposts;
    }
    public void setCrossposts(Set<CollectionCrossposts> crossposts) {
        this.crossposts = crossposts;
    }
    //TODO all the shit
}
