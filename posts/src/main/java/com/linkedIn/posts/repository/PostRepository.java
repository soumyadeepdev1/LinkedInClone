package com.linkedIn.posts.repository;


import com.linkedIn.posts.entity.PostRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostRecord,Long> {
}
