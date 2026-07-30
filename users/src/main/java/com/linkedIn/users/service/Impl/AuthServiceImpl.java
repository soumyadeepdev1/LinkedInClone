package com.linkedIn.users.service.Impl;

import com.linkedIn.users.dto.request.LoginRequest;
import com.linkedIn.users.dto.request.SignupRequest;
import com.linkedIn.users.dto.response.LoginResponse;
import com.linkedIn.users.dto.response.SignupResponse;
import com.linkedIn.users.entity.User;
import com.linkedIn.users.enums.AppRole;
import com.linkedIn.users.exception.UserAlreadyExistsException;
import com.linkedIn.users.exception.UserDoesNotExistsException;
import com.linkedIn.users.mapper.UserMapper;
import com.linkedIn.users.repository.UserRepository;
import com.linkedIn.users.service.AuthService;
import com.linkedIn.users.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public SignupResponse signup(SignupRequest signupRequest) {

        Optional<User> user = userRepository.findByUserName(signupRequest.userName());

        if(user.isPresent())
            throw new UserAlreadyExistsException("User already exists with userName: "+signupRequest.userName());

        User createdUser = User.builder()
                .userName(signupRequest.userName())
                .passwordHash(passwordEncoder.encode(signupRequest.password()))
                .roles(signupRequest.roleRequests())
                .build();

        userRepository.save(createdUser);

        return userMapper.userToSignupResponseMapper(
                new User(createdUser.getId(),createdUser.getUsername(),signupRequest.password(),createdUser.getRoles())
        );
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.userName(),loginRequest.password()));

        Set<AppRole> roles = userRepository.findByUserName(((User) auth.getPrincipal()).getUsername()).get().getRoles();


        String accessToken = jwtUtil.generateToken(((User) auth.getPrincipal()).getUsername(),roles);

        return new LoginResponse(accessToken);

    }
}
