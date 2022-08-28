package com.example.spring_security_demo.mapper;


import com.example.spring_security_demo.dto.reuqest.UserRegisterDto;
import com.example.spring_security_demo.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserEntityMapper implements Function<UserRegisterDto, User> {


    @Override
    public User apply(UserRegisterDto userRegisterDto) {
        return User.builder()
                .name(userRegisterDto.getName())
                .surname(userRegisterDto.getSurname())
                .email(userRegisterDto.getEmail())
                .password(userRegisterDto.getPassword())
                .roles(userRegisterDto.getRoles())
                .build();
    }
}
