package com.linkedIn.users.dto.request;

import com.linkedIn.users.enums.AppRole;

import java.util.Set;

public record SignupRequest(String userName, String password, Set<AppRole> roleRequests) {
}
