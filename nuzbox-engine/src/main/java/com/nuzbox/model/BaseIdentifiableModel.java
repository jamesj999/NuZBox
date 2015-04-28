package com.nuzbox.model;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by james on 22/04/15.
 */
@Entity
public abstract class BaseIdentifiableModel implements Serializable, BaseModelInterface {

    @Id
    @GeneratedValue
    private Long identity;

    private Date creationTime;
    private Date modificationTime;

    public Long getIdentity() {
        return identity;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

}
