package com.linkedIn.posts.service;

import com.linkedIn.posts.dto.response.PostLike;
import com.linkedIn.posts.entity.PostLikeRecord;

public interface PostLikeService {

    public PostLike like(Long postId);
    public void unlike(Long postId);
}
