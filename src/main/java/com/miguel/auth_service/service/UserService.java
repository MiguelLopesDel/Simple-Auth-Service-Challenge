package com.miguel.auth_service.service;

import com.miguel.auth_service.domain.User;
import com.miguel.auth_service.domain.UserAuthenticated;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private final JwtService service;

    public UserService(JwtService service) {
        this.service = service;
    }

    public String createUser(User user) {
        if (users.contains(user))
            throw new IllegalArgumentException("User already exists");
        users.add(user);
        UserAuthenticated userDetails = this.findByName(user.name()).map(UserAuthenticated::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UsernamePasswordAuthenticationToken authUser = new UsernamePasswordAuthenticationToken(userDetails, user.password(), userDetails.getAuthorities());
        return service.generate(authUser);
    }

    public Optional<User> findByName(String name) {
        return users.stream().filter(n -> n.name().equals(name)).findFirst();
    }
}
