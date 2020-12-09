package com.codeacademy.eshop.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/h2/**", "/prisijungimas", "/public/**").permitAll()
                    .antMatchers("/private/**").authenticated()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/prisijungimas")
                    .loginProcessingUrl("/prisijungimas")
                    .usernameParameter("user")
                    .passwordParameter("pass")
                    .defaultSuccessUrl("/private/user")
                    .failureUrl("/prisijungimas?error")
                    .and()
                .logout()
                    .logoutUrl("/atsijungti");

        http.csrf().ignoringAntMatchers("/h2/**");
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{bcrypt}$2a$10$IgO.t36FA2.M15EMK2l7EuN3cdiRRvYOHmhQqH8ELnCjf7FUhZiy.")
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder().encode("admin"))
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
