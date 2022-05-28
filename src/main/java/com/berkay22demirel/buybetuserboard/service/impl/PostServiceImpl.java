package com.berkay22demirel.buybetuserboard.service.impl;

import com.berkay22demirel.buybetuserboard.model.Post;
import com.berkay22demirel.buybetuserboard.repository.PostRepository;
import com.berkay22demirel.buybetuserboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void create(String content) {
        Post post = new Post();
        post.setInsertDate(new Date());
        post.setContent(content);
        postRepository.save(post);
    }
}
