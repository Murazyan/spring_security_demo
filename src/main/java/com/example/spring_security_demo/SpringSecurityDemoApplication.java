package com.example.spring_security_demo;

import com.example.spring_security_demo.model.Role;
import com.example.spring_security_demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int roleSize = roleRepository.findAll().size();
        if(roleSize==0){
            roleRepository.save(new Role("admin"));
            roleRepository.save(new Role("user1"));
            roleRepository.save(new Role("user2"));
            roleRepository.save(new Role("user3"));
        }
    }
}
