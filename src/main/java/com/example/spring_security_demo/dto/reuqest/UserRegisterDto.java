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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_d")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private List<Role> roles;
}
