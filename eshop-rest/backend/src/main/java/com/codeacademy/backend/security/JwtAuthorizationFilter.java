package com.codeacademy.backend.security;

import static com.codeacademy.backend.security.SecurityConstants.AUTHORIZATION_HEADER;
import static com.codeacademy.backend.security.SecurityConstants.AUTHORIZATION_HEADER_PREFIX;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author tsimonavicius
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private JwtProvider jwtProvider;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        super(authenticationManager);
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (isNotEmpty(authorizationHeader) && authorizationHeader.startsWith(AUTHORIZATION_HEADER_PREFIX)) {
            String jwt = authorizationHeader.replace(AUTHORIZATION_HEADER_PREFIX, "");
            Authentication authentication = jwtProvider.getAuthentication(jwt);
        }
    }
}
