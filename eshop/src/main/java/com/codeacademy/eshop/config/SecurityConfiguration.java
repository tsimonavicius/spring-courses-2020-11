package com.codeacademy.eshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests((requests) -> requests.anyRequest().authenticated())
                .formLogin()
                    .permitAll()
                    .loginPage("/prisijungimas")
                    .loginProcessingUrl("/prisijungimas-submit")
                    .usernameParameter("user")
                    .passwordParameter("pass")
                    .failureUrl("/prisijungimas?error")
                    .and()
                .httpBasic();
    }
}
