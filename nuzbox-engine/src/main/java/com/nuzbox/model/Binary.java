package com.nuzbox.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Farrell on 22/04/2015.
 */
@Entity
public class Binary extends BaseModel {

    @GeneratedValue @Id
    private Long identity;

    @Type(type="com.nuzbox.persistence.types.PaddedStringType")
    @Column(length = 1000)
    private Character[] name;

    @ManyToOne
    @Column
    private Collection collection;

    @OneToMany
    @JoinColumn
    private Set<Part> parts;

    //totalParts maybe? or just size the damn Set

    @Type(type="com.nuzbox.persistence.types.PaddedStringType")
    @Column(length = 255)
    private Character[] hash;

    @Column
    private Long size;

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public Character[] getName() {
        return name;
    }

    public void setName(Character[] name) {
        this.name = name;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public Character[] getHash() {
        return hash;
    }

    public void setHash(Character[] hash) {
        this.hash = hash;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}
