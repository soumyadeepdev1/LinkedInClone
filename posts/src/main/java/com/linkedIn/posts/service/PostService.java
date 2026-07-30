package com.linkedIn.posts.service;

import com.linkedIn.posts.dto.request.CreatePostRequest;
import com.linkedIn.posts.dto.response.Post;

import java.util.List;

public interface PostService {
    public Post create(CreatePostRequest createPostRequest);

    public List<Post> getAll();

    public Post get(Long id);

}
