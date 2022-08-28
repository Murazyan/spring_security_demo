package com.example.spring_security_demo.mapper;


import com.example.spring_security_demo.dto.response.UserResponseDto;
import com.example.spring_security_demo.dto.reuqest.UserRegisterDto;
import com.example.spring_security_demo.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserResponseMapper implements Function<User, UserResponseDto> {


    @Override
    public UserResponseDto apply(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }
}
