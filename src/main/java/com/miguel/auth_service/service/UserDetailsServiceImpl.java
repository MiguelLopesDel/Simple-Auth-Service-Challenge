package com.miguel.auth_service.service;

import com.miguel.auth_service.domain.UserAuthenticated;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return service.findByName(username).map(UserAuthenticated::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
