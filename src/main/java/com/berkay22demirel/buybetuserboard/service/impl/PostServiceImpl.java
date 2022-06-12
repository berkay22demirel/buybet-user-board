package com.berkay22demirel.buybetuserboard.service.impl;

import com.berkay22demirel.buybetuserboard.controller.dto.PostDto;
import com.berkay22demirel.buybetuserboard.exception.BuybetNotFoundException;
import com.berkay22demirel.buybetuserboard.model.Post;
import com.berkay22demirel.buybetuserboard.model.User;
import com.berkay22demirel.buybetuserboard.repository.PostRepository;
import com.berkay22demirel.buybetuserboard.service.PostService;
import com.berkay22demirel.buybetuserboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public void create(String content, User user) {
        Post post = new Post();
        post.setInsertDate(new Date());
        post.setContent(content);
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public Page<PostDto> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable).map(PostDto::new);
    }

    @Override
    public Page<PostDto> getPostsByUser(String username, Pageable pageable) {
        User user = userService.getByUsername(username)
                .orElseThrow(() -> new BuybetNotFoundException("buybet.user.notFound"));
        return postRepository.findByUser(user, pageable).map(PostDto::new);
    }

    @Override
    public Page<PostDto> getPostsScroll(long lastId, Pageable pageable) {
        return postRepository.findByIdLessThan(lastId, pageable).map(PostDto::new);
    }
}
