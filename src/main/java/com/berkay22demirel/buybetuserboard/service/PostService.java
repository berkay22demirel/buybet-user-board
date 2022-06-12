package com.berkay22demirel.buybetuserboard.service;

import com.berkay22demirel.buybetuserboard.controller.dto.PostDto;
import com.berkay22demirel.buybetuserboard.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    void create(String content, User user);

    Page<PostDto> getPosts(Pageable pageable);

    Page<PostDto> getPostsByUser(String username, Pageable pageable);

    Page<PostDto> getPostsScroll(long lastId, Pageable pageable);

    Page<PostDto> getPostsByUserAndScroll(String username, long lastId, Pageable pageable);
}
