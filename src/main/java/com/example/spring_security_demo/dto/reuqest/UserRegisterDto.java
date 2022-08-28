package com.example.spring_security_demo.dto.reuqest;

import com.example.spring_security_demo.model.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class UserRegisterDto {

    private String name;

    private String surname;

    private String email;

    private String password;


    private List<Role> roles;
}
