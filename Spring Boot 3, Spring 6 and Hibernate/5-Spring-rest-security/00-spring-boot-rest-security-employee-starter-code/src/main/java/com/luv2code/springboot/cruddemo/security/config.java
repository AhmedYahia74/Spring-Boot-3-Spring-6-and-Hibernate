package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username,password,enabled from users where username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, authority from authorities where username=?"
        );
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeHttpRequests(configur->
                configur
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("Employee")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("Employee")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("Manager")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("Admin")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("Admin")
                );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }
}


//    @Bean
//    InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails Ahmed = User.builder()
//                .roles("Employee")
//                .username("ahmed")
//                .password("{noop}admin")
//                .build();
//
//        UserDetails Yahia = User.builder()
//                .roles("Employee", "Manager")
//                .username("yahia")
//                .password("{noop}admin")
//                .build();
//
//        UserDetails Belal = User.builder()
//                .username("belal")
//                .password("{noop}admin")
//                .roles("Employee", "Manager", "Admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(Ahmed, Yahia, Belal);
//    }
