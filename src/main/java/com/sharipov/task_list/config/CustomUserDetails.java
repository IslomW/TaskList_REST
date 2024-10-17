package com.sharipov.task_list.config;

import com.sharipov.task_list.domain.entity.profile.GeneralStatus;
import com.sharipov.task_list.domain.entity.profile.Profile;
import com.sharipov.task_list.domain.entity.profile.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Data
public class CustomUserDetails implements UserDetails {


    private Long id;
    private String name;
    private String username;
    private String phone;
    private String password;
    private Role role;
    private GeneralStatus status;

    public CustomUserDetails(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.username = profile.getUsername();
        this.password = profile.getPassword();
        this.role = profile.getRole();
        this.status = profile.getStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
