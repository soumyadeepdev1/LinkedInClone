package com.linkedIn.posts.mapper;

import com.linkedIn.posts.dto.response.Post;
import com.linkedIn.posts.entity.PostRecord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    public Post postRecordToPostMapper(PostRecord postRecord);

    List<Post> postRecordListToPostListMapper(List<PostRecord> postRecords);
}
