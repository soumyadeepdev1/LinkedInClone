package com.linkedIn.posts.dto.response;

import java.time.LocalDateTime;

public record Post (
        Long id,
        String content,
        Long postedBy,
        LocalDateTime createdAt
){
}
