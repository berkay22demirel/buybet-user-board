package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.annotations.CurrentUser;
import com.berkay22demirel.buybetuserboard.constant.ResponseStatus;
import com.berkay22demirel.buybetuserboard.controller.dto.PostDto;
import com.berkay22demirel.buybetuserboard.controller.request.CreatePostRequest;
import com.berkay22demirel.buybetuserboard.controller.response.Response;
import com.berkay22demirel.buybetuserboard.model.User;
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
@RequestMapping("api/1.0")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Response> create(@Valid @RequestBody CreatePostRequest request, @CurrentUser User user) {
        postService.create(request.getContent(), user);
        return ResponseEntity.ok(new Response(ResponseStatus.SUCCESS));
    }

    @GetMapping("/posts")
    public ResponseEntity<Response> getPosts(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PostDto> postList = postService.getPosts(pageable);
        return ResponseEntity.ok(new Response(postList));
    }

    @GetMapping("/users/{username}/posts")
    public ResponseEntity<Response> getPostsByUser(@PathVariable String username, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PostDto> postList = postService.getPostsByUser(username, pageable);
        return ResponseEntity.ok(new Response(postList));
    }
}
