package com.nuzbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by james on 24/04/15.
 */
@Entity
public class CronJob extends BaseVersionedModel {

    @Id
    @GeneratedValue
    private long identity;

    @Column
    private String testAttribute;

    @Column(nullable = false)
    private String anotherTestAttribute;

    @Column(nullable = false)
    private String performableClass;

    public String getPerformableClass() {
        return performableClass;
    }
    public void setPerformableClass(String performableClass) {this.performableClass = performableClass;}
    public long getIdentity() {
        return identity;
    }
    public String getTestAttribute() {
        return testAttribute;
    }
    public void setTestAttribute(String testAttribute) {
        this.testAttribute = testAttribute;
    }
    public String getAnotherTestAttribute() {
        return anotherTestAttribute;
    }
    public void setAnotherTestAttribute(String anotherTestAttribute) {this.anotherTestAttribute = anotherTestAttribute;}
}
