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
    private long id;

    @Column
    private String someOtherShit;
    @Column
    private String yetMoreShit;
    @Column
    private String evenMoreShit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getYetMoreShit() {
        return yetMoreShit;
    }

    public void setYetMoreShit(String yetMoreShit) {
        this.yetMoreShit = yetMoreShit;
    }

    public String getSomeOtherShit() {
        return someOtherShit;
    }

    public void setSomeOtherShit(String someOtherShit) {
        this.someOtherShit = someOtherShit;
    }

    public String getEvenMoreShit() {
        return evenMoreShit;
    }

    public void setEvenMoreShit(String evenMoreShit) {
        this.evenMoreShit = evenMoreShit;
    }
}
