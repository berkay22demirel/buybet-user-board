package com.berkay22demirel.buybetuserboard.service;

import com.berkay22demirel.buybetuserboard.constant.ScrollDirectionEnum;
import com.berkay22demirel.buybetuserboard.controller.dto.PostDto;
import com.berkay22demirel.buybetuserboard.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    void create(String content, User user);

    Page<PostDto> getPosts(Pageable pageable);

    Page<PostDto> getPostsByUser(String username, Pageable pageable);

    Iterable<PostDto> getPostsScroll(long lastId, Pageable pageable, ScrollDirectionEnum direction);

    Iterable<PostDto> getPostsByUserAndScroll(String username, long lastId, Pageable pageable, ScrollDirectionEnum direction);

    void deletePost(long id);

    boolean isAllowedToDeletePost(long postId, User user);
}
