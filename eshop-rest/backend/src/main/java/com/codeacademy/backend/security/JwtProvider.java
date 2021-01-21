package com.codeacademy.backend.security;

import org.springframework.security.core.userdetails.User;

/**
 * @author tsimonavicius
 */
public class JwtProvider {
    public String createToken(User user) {
        return "cia.mano.token";
    }
}
