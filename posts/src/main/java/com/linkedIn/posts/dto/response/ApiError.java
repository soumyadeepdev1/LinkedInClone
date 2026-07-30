package com.linkedIn.posts.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiError(
        String errorCode,
        String errorMessage,
        String apiPath,
        LocalDateTime timeStamp
) {

    public static ApiError of(String errorCode, String errorMessage, String apiPath, LocalDateTime timeStamp){
        return new ApiError(errorCode, errorMessage, apiPath, timeStamp);
    }
}
