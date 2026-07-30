package com.linkedIn.posts.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class ResourceNotFoundException extends RuntimeException{
    private final String errorCode;

    public ResourceNotFoundException(String resource, Map<String,String> identifiers){
        super(resource+" not found with "+identifiers.entrySet().stream().map(entry->entry.getKey()+":"+entry.getValue()).reduce(
                (e1,e2)-> e1 +", "+ e2 ).get()
        );
        this.errorCode = "NOT_FOUND_"+resource;
    }
}
