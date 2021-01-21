package com.codeacademy.backend.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author tsimonavicius
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            Map<String, String> credentials = new ObjectMapper().readValue(request.getReader(), new TypeReference<>() {
            });

            String username = credentials.get(USERNAME);
            String password = credentials.get(PASSWORD);

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new BadCredentialsException("Provided structure was incorrect.");
        }
    }
}
