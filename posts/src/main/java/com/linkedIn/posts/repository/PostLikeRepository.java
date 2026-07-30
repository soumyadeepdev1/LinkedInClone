package com.linkedIn.posts.repository;

import com.linkedIn.posts.dto.response.PostLike;
import com.linkedIn.posts.entity.PostLikeRecord;
import com.linkedIn.posts.entity.PostRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLikeRecord,Long> {

    Optional<PostLike> findByPost(PostRecord post);

    Optional<PostLikeRecord> findByPost_IdAndLikedBy(Long id, Long likedBy);
}
