package com.example.spring_security_demo.service.impl;

import com.example.spring_security_demo.dto.auth.AuthorizationRequest;
import com.example.spring_security_demo.dto.auth.AuthorizationResponse;
import com.example.spring_security_demo.dto.response.UserResponseDto;
import com.example.spring_security_demo.dto.reuqest.UserRegisterDto;
import com.example.spring_security_demo.repository.UserRepository;
import com.example.spring_security_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponseDto> userById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponseDto> register(UserRegisterDto userData) {
        return null;
    }

    @Override
    public ResponseEntity<AuthorizationResponse> login(AuthorizationRequest authorizationRequest) {
        return null;
    }
}
