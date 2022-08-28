package com.example.spring_security_demo.service.impl;

import com.example.spring_security_demo.dto.auth.AuthorizationRequest;
import com.example.spring_security_demo.dto.auth.AuthorizationResponse;
import com.example.spring_security_demo.dto.response.UserResponseDto;
import com.example.spring_security_demo.dto.reuqest.UserRegisterDto;
import com.example.spring_security_demo.mapper.UserEntityMapper;
import com.example.spring_security_demo.mapper.UserResponseMapper;
import com.example.spring_security_demo.model.User;
import com.example.spring_security_demo.repository.UserRepository;
import com.example.spring_security_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper entityMapper;
    private final UserResponseMapper responseMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<UserResponseDto> userById(UUID id) {
        return null;
    }

    @Override
    public UserResponseDto register(UserRegisterDto userData) {
        if (!userRepository.existsByEmail(userData.getEmail())) {
            User user = entityMapper.apply(userData);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return responseMapper.apply(userRepository.save(user));
        } else {
            throw new RuntimeException("User with email = " + userData.getEmail() + " already exists");
        }
    }

    @Override
    public ResponseEntity<AuthorizationResponse> login(AuthorizationRequest authorizationRequest) {
        return null;
    }
}
