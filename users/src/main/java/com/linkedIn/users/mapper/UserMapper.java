package com.linkedIn.users.mapper;

import com.linkedIn.users.dto.response.SignupResponse;
import com.linkedIn.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "passwordHash",target = "password")
    public SignupResponse userToSignupResponseMapper(User user);
}
