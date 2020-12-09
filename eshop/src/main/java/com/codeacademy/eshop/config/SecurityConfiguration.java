package com.codeacademy.eshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/h2/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/prisijungimas")
                    .loginProcessingUrl("/prisijungimas")
                    .usernameParameter("user")
                    .passwordParameter("pass")
                    .defaultSuccessUrl("/product")
                    .failureUrl("/prisijungimas?error");

        http.csrf().ignoringAntMatchers("/h2/**");
        http.headers().frameOptions().sameOrigin();
    }
}
