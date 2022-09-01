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
import com.example.spring_security_demo.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper entityMapper;
    private final UserResponseMapper responseMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil tokenUtil;

    @Override
    public UserResponseDto userById(Long id) {
        return userRepository.findById(id).map(responseMapper).orElse(null);
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
    public AuthorizationResponse login(AuthorizationRequest authorizationRequest) {
        Optional<User> userOptional = userRepository.findByEmail(authorizationRequest.getEmail());
        if (userOptional.isPresent() && passwordEncoder.matches(authorizationRequest.getPassword(), userOptional.get().getPassword())) {
            return new AuthorizationResponse(true, tokenUtil.generateToken(userOptional.get()));
        } else {
            return new AuthorizationResponse(false, null);
        }
    }
}
