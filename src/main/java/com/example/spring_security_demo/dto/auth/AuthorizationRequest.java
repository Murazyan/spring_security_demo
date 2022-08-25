package com.example.spring_security_demo.dto.auth;


import lombok.Data;

@Data
public class AuthorizationRequest {

    private String email;

    private String password;
}
