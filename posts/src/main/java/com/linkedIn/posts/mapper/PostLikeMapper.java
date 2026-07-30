package com.linkedIn.posts.mapper;

import com.linkedIn.posts.dto.response.PostLike;
import com.linkedIn.posts.entity.PostLikeRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostLikeMapper {
    @Mapping(source = "post.id",target = "postId")
    PostLike postLikeRecordToPostLikeMapper(PostLikeRecord postLikeRecord);
}
