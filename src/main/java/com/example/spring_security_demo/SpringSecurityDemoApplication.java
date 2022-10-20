package com.example.spring_security_demo;

import com.example.spring_security_demo.model.Role;
import com.example.spring_security_demo.model.User;
import com.example.spring_security_demo.repository.RoleRepository;
import com.example.spring_security_demo.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    JwtTokenUtil tokenUtil;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("*****************");
//        System.out.println(tokenUtil.generateToken(User.builder()
//                .id(11L)
//                .email("Poxos@gmail.com")
//                .password("123")
//                .name("Poxos")
//                .surname("Poxosyan")
//                .build()));

//        String emailFromToken = tokenUtil.getEmailFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQb3hvc0BnbWFpbC5jb20iLCJpZCI6MTEsImV4cCI6MTY3NTAyMTk3NCwidXNlciI6eyJpZCI6MTEsIm5hbWUiOiJQb3hvcyIsInN1cm5hbWUiOiJQb3hvc3lhbiIsImVtYWlsIjoiUG94b3NAZ21haWwuY29tIiwicGFzc3dvcmQiOiIxMjMiLCJjcmVhdGVkIjpudWxsLCJ1cGRhdGVkIjpudWxsLCJyb2xlcyI6bnVsbH0sImlhdCI6MTY2NjAyMTk3NH0.MAtoxCySBOO6L83o8D5raD9G8blR7pTSaJBBmCni4qmJ4luvaqDDxZWlJr_-8PKVHnUXa-Usi5VYdd8msdpVLA");
//        System.out.println("Email "+emailFromToken);
//        LinkedHashMap user = tokenUtil.getAllClaimsFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQb3hvc0BnbWFpbC5jb20iLCJpZCI6MTEsImV4cCI6MTY3NTAyMTk3NCwidXNlciI6eyJpZCI6MTEsIm5hbWUiOiJQb3hvcyIsInN1cm5hbWUiOiJQb3hvc3lhbiIsImVtYWlsIjoiUG94b3NAZ21haWwuY29tIiwicGFzc3dvcmQiOiIxMjMiLCJjcmVhdGVkIjpudWxsLCJ1cGRhdGVkIjpudWxsLCJyb2xlcyI6bnVsbH0sImlhdCI6MTY2NjAyMTk3NH0.MAtoxCySBOO6L83o8D5raD9G8blR7pTSaJBBmCni4qmJ4luvaqDDxZWlJr_-8PKVHnUXa-Usi5VYdd8msdpVLA").get("user", LinkedHashMap.class);
//        System.out.println("User from toke "+user);
//        System.out.println("User from toke id"+user.get("id"));
        int roleSize = roleRepository.findAll().size();
        if (roleSize == 0) {
            roleRepository.save(new Role("admin"));
            roleRepository.save(new Role("manager"));
            roleRepository.save(new Role("cashier"));
            roleRepository.save(new Role("user"));
        }
    }
}
