package com.example.spring_security_demo.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserResponseDto {

    private UUID id;

    private String name;

    private String surname;

    private String email;

    private List<RoleResponseDto> roles = new ArrayList<>();

}
