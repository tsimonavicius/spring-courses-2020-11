package com.codeacademy.backend.security;

import static com.codeacademy.backend.security.SecurityConstants.AUTHORIZATION_HEADER;
import static com.codeacademy.backend.security.SecurityConstants.AUTHORIZATION_HEADER_PREFIX;
import static com.codeacademy.backend.security.SecurityConstants.PASSWORD_FIELD;
import static com.codeacademy.backend.security.SecurityConstants.USERNAME_FIELD;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author tsimonavicius
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private JwtProvider jwtProvider;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        super(authenticationManager);
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            Map<String, String> credentials = new ObjectMapper().readValue(request.getReader(), new TypeReference<>() {
            });

            String username = credentials.get(USERNAME_FIELD);
            String password = credentials.get(PASSWORD_FIELD);

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new BadCredentialsException("Provided structure was incorrect.");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();

        String jwtToken = jwtProvider.createToken(user);

        response.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_PREFIX + jwtToken);
    }
}
