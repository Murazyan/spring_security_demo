package com.example.spring_security_demo.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleResponseDto {

    private UUID id;

    private String name;

}
