package com.miguel.auth_service.service;

import com.miguel.auth_service.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserAuthenticated implements UserDetails {
    private final User user;

    @Override
    public String getUsername() {
        return user.name();
    }

    @Override
    public String getPassword() {
        return user.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "auth");
    }
}
