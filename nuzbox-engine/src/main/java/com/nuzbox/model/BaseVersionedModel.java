package com.nuzbox.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

/**
 * Created by Farrell on 23/04/2015.
 */
@MappedSuperclass
public abstract class BaseVersionedModel extends BaseModel {

    @Version
    private Integer version;
    @Version
    private Date lastUpdated;

    public Integer getVersion() {
        return version;
    }

    public Date getLastUpdate() {
        return lastUpdated;
    }
}
