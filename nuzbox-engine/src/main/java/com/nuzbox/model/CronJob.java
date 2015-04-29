package com.nuzbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by james on 24/04/15.
 */
@Entity
public class CronJob extends BaseModel {

    @Id
    @GeneratedValue
    private long identity;

    @Column
    private String someOtherShit;

    public long getIdentity() {
        return identity;
    }

}
