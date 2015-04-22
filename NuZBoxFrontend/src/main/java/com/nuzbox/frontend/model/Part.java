package com.nuzbox.frontend.model;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by Farrell on 22/04/2015.
 */
@Entity
public class Part implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long identity;

    @ManyToOne
    private Binary binary;

    @Type(type="com.nuzbox.frontend.persistence.types.PaddedStringType")
    @Column(length = 255)
    private Character[] message;
    private Long articleRef;
    private Integer number;
    private Long size;

    public Part() {

    }

    public Part(Binary binary, Character[] message, Long articleRef, Integer number, Long size) {
        this.binary = binary;
        this.message = message;
        this.articleRef = articleRef;
        this.number = number;
        this.size = size;
    }

    public Long getIdentity() {
        return identity;
    }

    public Character[] getMessage() {
        return message;
    }

    public void setMessage(Character[] message) {
        this.message = message;
    }

    public Long getArticleRef() {
        return articleRef;
    }

    public void setArticleRef(Long articleRef) {
        this.articleRef = articleRef;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
