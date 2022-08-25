package com.example.spring_security_demo.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationResponse {

    private boolean authorized;
    private String token;
}
