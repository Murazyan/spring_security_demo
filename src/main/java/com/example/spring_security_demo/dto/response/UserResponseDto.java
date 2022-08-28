package com.example.spring_security_demo.dto.response;

import com.example.spring_security_demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private List<Role> roles = new ArrayList<>();

}
