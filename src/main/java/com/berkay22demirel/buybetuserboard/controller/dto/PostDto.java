package com.berkay22demirel.buybetuserboard.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private Long id;
    private Date postDate;
    private String content;
}
