package com.nuzbox.model;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;

import java.io.Serializable;

/**
 * Created by james on 22/04/15.
 */
@Entity
public abstract class BaseIdentifiableModel implements Serializable,BaseModelInterface{

    @Id @GeneratedValue
    private Long identity;

    public Long getIdentity() {
        return identity;
    }

}
