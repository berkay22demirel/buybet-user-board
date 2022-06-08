package com.berkay22demirel.buybetuserboard.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "insert_date", nullable = false)
    private Date insertDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(nullable = false, length = 210)
    private String content;
}
