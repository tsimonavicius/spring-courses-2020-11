package com.codeacademy.backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codeacademy.backend.entity.User;

/**
 * @author tsimonavicius
 */
@Service
public class UserService implements UserDetailsService {
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
