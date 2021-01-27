package com.codeacademy.backend.controller;

import com.codeacademy.backend.controller.dto.UserDTO;
import com.codeacademy.backend.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public UserDTO user(@AuthenticationPrincipal User user) {
        return new UserDTO(user);
    }
}
