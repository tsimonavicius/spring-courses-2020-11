package com.codeacademy.backend.controller.dto;

import com.codeacademy.backend.entity.Role;
import com.codeacademy.backend.entity.User;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private Set<String> roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());
    }
}
