package com.miguel.auth_service.service;

import com.miguel.auth_service.domain.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final TokenService service;

    public String createUser(UserDTO userDTO) {
        return service.generate(userDTO);
    }
}
