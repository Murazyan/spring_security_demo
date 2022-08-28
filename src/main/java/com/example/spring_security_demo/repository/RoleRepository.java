package com.example.spring_security_demo.repository;

import com.example.spring_security_demo.model.Role;
import com.example.spring_security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
