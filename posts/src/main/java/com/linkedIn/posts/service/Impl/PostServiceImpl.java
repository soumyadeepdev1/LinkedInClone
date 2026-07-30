package com.linkedIn.posts.service.Impl;


import com.linkedIn.posts.dto.request.CreatePostRequest;
import com.linkedIn.posts.dto.response.Post;
import com.linkedIn.posts.entity.PostRecord;
import com.linkedIn.posts.exception.ResourceNotFoundException;
import com.linkedIn.posts.mapper.PostMapper;
import com.linkedIn.posts.repository.PostRepository;
import com.linkedIn.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public Post create(CreatePostRequest createPostRequest) {
        PostRecord createdPost =  postRepository.save(
            PostRecord.builder()
            .content(createPostRequest.content())
            .postedBy(1L)
            .build()
        );
        return postMapper.postRecordToPostMapper(createdPost);
    }

    @Override
    public List<Post> getAll() {
        return postMapper.postRecordListToPostListMapper(postRepository.findAll());
    }

    @Override
    public Post get(Long id) {
        return postMapper.postRecordToPostMapper(
                postRepository.findById(id).orElseThrow(()->
                    new ResourceNotFoundException("POST", Map.of("ID",id.toString()))
        ));
    }
}
