package com.berkay22demirel.buybetuserboard.controller.dto;

import com.berkay22demirel.buybetuserboard.model.Post;
import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private Long id;
    private Date postDate;
    private String content;
    private UserDto user;

    public PostDto(Post post) {
        this.id = post.getId();
        this.postDate = post.getInsertDate();
        this.content = post.getContent();
        this.user = new UserDto(post.getUser());
    }
}
