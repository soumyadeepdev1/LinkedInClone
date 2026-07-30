package com.linkedIn.users.exception;

public class UserDoesNotExistsException extends RuntimeException{
    public UserDoesNotExistsException(String message){
        super(message);
    }
}
