package com.linkedIn.users.controller;


import com.linkedIn.users.dto.request.LoginRequest;
import com.linkedIn.users.dto.request.SignupRequest;
import com.linkedIn.users.dto.response.LoginResponse;
import com.linkedIn.users.dto.response.SignupResponse;
import com.linkedIn.users.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
            authService.signup(signupRequest)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                authService.login(loginRequest)
        );
    }
}
