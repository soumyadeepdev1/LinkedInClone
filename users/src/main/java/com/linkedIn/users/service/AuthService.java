package com.linkedIn.users.service;

import com.linkedIn.users.dto.request.LoginRequest;
import com.linkedIn.users.dto.request.SignupRequest;
import com.linkedIn.users.dto.response.LoginResponse;
import com.linkedIn.users.dto.response.SignupResponse;

public interface AuthService {
    public SignupResponse signup(SignupRequest signupRequest);
    public LoginResponse login(LoginRequest loginRequest) ;
}
