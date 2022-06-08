package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.constant.ResponseStatus;
import com.berkay22demirel.buybetuserboard.controller.dto.PostDto;
import com.berkay22demirel.buybetuserboard.controller.request.CreatePostRequest;
import com.berkay22demirel.buybetuserboard.controller.response.Response;
import com.berkay22demirel.buybetuserboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/1.0/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody CreatePostRequest request) {
        postService.create(request.getContent());
        return ResponseEntity.ok(new Response(ResponseStatus.SUCCESS));
    }

    @GetMapping
    public ResponseEntity<Response> getPosts(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PostDto> postList = postService.getPosts(pageable);
        return ResponseEntity.ok(new Response(postList));
    }
}
