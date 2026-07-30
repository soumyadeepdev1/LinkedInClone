package com.linkedIn.posts.controller;


import com.linkedIn.posts.dto.request.CreatePostRequest;
import com.linkedIn.posts.dto.response.Post;
import com.linkedIn.posts.dto.response.PostLike;
import com.linkedIn.posts.service.PostLikeService;
import com.linkedIn.posts.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostService postService;
    private final PostLikeService postLikeService;

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody @Valid CreatePostRequest createPostRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(createPostRequest));
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAll(){

        return ResponseEntity.status(HttpStatus.OK).body(postService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(postService.get(id));
    }

    @PostMapping("like/{id}")
    public ResponseEntity<PostLike> like(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.CREATED).body(postLikeService.like(id));
    }

    @DeleteMapping("unlike/{id}")
    public ResponseEntity<PostLike> unlike(@PathVariable Long id){
        postLikeService.unlike(id);
        return ResponseEntity.noContent().build();
    }
}
