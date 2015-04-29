package com.nuzbox.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Farrell on 29/04/2015.
 */
@Entity
public class Release extends BaseVersionedModel {

    @Id @GeneratedValue
    private Integer identity;

    @ManyToOne
    private Category category;

    @Column
    private String name;

    @OneToOne
    private Group group;

    @Column
    private Long size;

    @Column
    private Date postDate;

    @Column
    private Date addedDate;

    @Column
    private String from;

    @Column
    private BigDecimal completion;

    public Integer getIdentity() {
        return identity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public BigDecimal getCompletion() {
        return completion;
    }

    public void setCompletion(BigDecimal completion) {
        this.completion = completion;
    }
}
