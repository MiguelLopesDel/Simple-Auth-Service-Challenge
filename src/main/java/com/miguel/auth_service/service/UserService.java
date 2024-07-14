package com.miguel.auth_service.service;

import com.miguel.auth_service.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Set<User> users = new HashSet<>();
    private final JwtService service;

    public UserService(JwtService service) {
        this.service = service;
        users.add(new User("miguel", "{noop}aaa"));
    }

    public String createUser(Authentication user) {
//        users.add(user);
        return service.generate(user);
    }

    public Optional<User> findByName(String name) {
        return users.stream().filter(n -> n.name().equals(name)).findFirst();
    }
}
