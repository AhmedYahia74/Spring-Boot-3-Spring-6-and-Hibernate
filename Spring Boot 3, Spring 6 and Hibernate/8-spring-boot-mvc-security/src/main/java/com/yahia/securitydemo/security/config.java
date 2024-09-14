package com.yahia.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class config {
    @Bean
    public UserDetailsManager memoryUserDetailsManager(DataSource dataSource) {
       return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configer -> configer
                        .requestMatchers("/").hasRole("Employee")
                        .requestMatchers("/Leaders/**").hasRole("Manager")
                        .requestMatchers("/Systems/**").hasRole("Admin")
                        .anyRequest().authenticated())
                .formLogin(form ->
                        form.loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .exceptionHandling(cinf ->cinf.accessDeniedPage("/access-denied"))
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}
