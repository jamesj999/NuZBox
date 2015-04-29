package com.nuzbox.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Farrell on 29/04/2015.
 */
public class Release extends BaseVersionedModel {

    @Id @GeneratedValue
    private Integer identity;

    @Column
    @ManyToOne
    private Category category;

    @Column
    private String name;

    @Column
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
}
