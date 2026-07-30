package com.linkedIn.posts.service.Impl;

import com.linkedIn.posts.dto.response.PostLike;
import com.linkedIn.posts.entity.PostLikeRecord;
import com.linkedIn.posts.entity.PostRecord;
import com.linkedIn.posts.exception.BadRequestException;
import com.linkedIn.posts.exception.ResourceNotFoundException;
import com.linkedIn.posts.mapper.PostLikeMapper;
import com.linkedIn.posts.repository.PostLikeRepository;
import com.linkedIn.posts.repository.PostRepository;
import com.linkedIn.posts.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostLikeMapper postLikeMapper;

    @Override
    public PostLike like(Long postId) {

        PostRecord postToBeLiked = postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("POST", Map.of("ID",postId.toString())));

        Optional<PostLike> existingLike = postLikeRepository.findByPost(postToBeLiked);

        if(existingLike.isPresent()){
            log.info("Post with ID:{} has been already liked by user with ID:{} ",postId,1L);
            return existingLike.get();
        }

        return postLikeMapper.postLikeRecordToPostLikeMapper(
                postLikeRepository.save(PostLikeRecord.builder().likedBy(1L).post(postToBeLiked).build())
        );
    }

    @Override
    public void unlike(Long postId) {

        PostRecord postToBeUnliked = postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("POST",Map.of("ID",postId.toString())));

        PostLikeRecord likeEntry = postLikeRepository.findByPost_IdAndLikedBy(postToBeUnliked.getId(),1L).orElseThrow(
                ()-> new ResourceNotFoundException("POST_LIKE",Map.of("ID",postId.toString(),"LIKED_BY",String.valueOf(1L)))
        );

        postLikeRepository.delete(likeEntry);

    }
}
