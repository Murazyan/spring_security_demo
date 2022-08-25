package com.example.spring_security_demo.service.security;

import com.example.spring_security_demo.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {

        super(user.getEmail(), user.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList(getRoleNames(user)));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    private static String[] getRoleNames(User user) {
        List<String> roles = user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList());
        String[] roleNames = new String[user.getRoles().size()];
        for (int i = 0; i < roles.size(); i++) {
            roleNames[i] = roles.get(i);
        }
        return roleNames;
    }

}