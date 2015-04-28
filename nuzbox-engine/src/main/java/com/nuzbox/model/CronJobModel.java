package com.nuzbox.model;

import com.nuzbox.model.BaseIdentifiableModel;

/**
 * Created by james on 24/04/15.
 */
public class CronJobModel extends BaseIdentifiableModel {
    private long id;
    private String someOtherShit;
    private String yetMoreShit;
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
