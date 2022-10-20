package com.example.spring_security_demo.controller;

import com.example.spring_security_demo.dto.auth.AuthorizationRequest;
import com.example.spring_security_demo.dto.auth.AuthorizationResponse;
import com.example.spring_security_demo.dto.response.UserResponseDto;
import com.example.spring_security_demo.dto.reuqest.UserRegisterDto;
import com.example.spring_security_demo.service.UserService;
import com.example.spring_security_demo.service.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('cashier', 'manager')")
    @PreAuthorize("hasAuthority('cashier')")
    public ResponseEntity<UserResponseDto> userById(@AuthenticationPrincipal CurrentUser currentUser,
                                                    @PathVariable("id") Long id) {
//        UsernamePasswordAuthenticationToken currentUser = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("**** " + ((CurrentUser) currentUser.getPrincipal()).getUser());
        System.out.println("**** " + currentUser);
        return ResponseEntity.ok(userService.userById(id));
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody final UserRegisterDto userData) {
        return ResponseEntity.ok(userService.register(userData));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> login(@RequestBody final AuthorizationRequest authorizationRequest) {
        AuthorizationResponse response = userService.login(authorizationRequest);
        if (response.isAuthorized())
            return ResponseEntity.ok(response);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
