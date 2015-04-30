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
    private String hash;

    @Column
    private Date dateAdded;

    @OneToOne
    private Release release;

    @OneToMany(mappedBy = "collection")
    private Set<CollectionCrossposts> crossposts;

    public Integer getIdentity() {
        return identity;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Set<CollectionCrossposts> getCrossposts() {
        return crossposts;
    }

    public void setCrossposts(Set<CollectionCrossposts> crossposts) {
        this.crossposts = crossposts;
    }


}
