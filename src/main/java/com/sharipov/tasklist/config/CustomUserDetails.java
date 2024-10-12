package com.sharipov.tasklist.config;

import com.sharipov.tasklist.domain.entity.user.Role;
import com.sharipov.tasklist.domain.entity.user.User;

import lombok.Getter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
public class CustomUserDetails implements UserDetails {
    private Long id;
    private String name;
    private String username;
    private String password;

    private Role role;


    public CustomUserDetails(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role.name()));
        return roles;
    }
}
