package com.berkay22demirel.buybetuserboard.service;

import com.berkay22demirel.buybetuserboard.controller.dto.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    void create(String content);

    Page<PostDto> getPosts(Pageable pageable);
}
