package com.berkay22demirel.buybetuserboard.service.impl;

import com.berkay22demirel.buybetuserboard.controller.dto.PostDto;
import com.berkay22demirel.buybetuserboard.model.Post;
import com.berkay22demirel.buybetuserboard.repository.PostRepository;
import com.berkay22demirel.buybetuserboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

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

    @Override
    public Page<PostDto> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable).map(this::convertToPostDto);
    }

    private PostDto convertToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setPostDate(Optional.ofNullable(post.getUpdateDate()).orElse(post.getInsertDate()));
        return postDto;
    }
}
