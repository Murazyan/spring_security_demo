package com.example.spring_security_demo.service;

import com.example.spring_security_demo.dto.auth.AuthorizationRequest;
import com.example.spring_security_demo.dto.auth.AuthorizationResponse;
import com.example.spring_security_demo.dto.response.UserResponseDto;
import com.example.spring_security_demo.dto.reuqest.UserRegisterDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserService {


    ResponseEntity<UserResponseDto> userById(UUID id);

    UserResponseDto register(UserRegisterDto userData);

    ResponseEntity<AuthorizationResponse> login(AuthorizationRequest authorizationRequest);

}
