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

    @Column(length = 1000)
    private String name;

    @ManyToOne
    private Collection collection;

    @OneToMany(mappedBy = "binary")
    private Set<Part> parts;

    //totalParts maybe? or just size the damn Set

    @Column(length = 255)
    private String hash;

    @Column
    private Long size;

    public Long getIdentity() {
        return identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}
