package com.nuzbox.model;

import javax.persistence.Entity;
import javax.persistence.Version;
import java.util.Date;

/**
 * Created by Farrell on 23/04/2015.
 */
@Entity
public abstract class BaseIdentifiableVersionedModel extends BaseIdentifiableModel{

    @Version
    private Integer version;
    @Version
    private Date lastUpdated;

    public Integer getVerion() {
        return version;
    }

    public Date getLastUpdate() {
        return lastUpdated;
    }
}
