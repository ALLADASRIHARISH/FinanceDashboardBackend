package com.example.financedashboardbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // ✅ Dashboard & Records GET → all roles
                        .requestMatchers(HttpMethod.GET, "/records/**", "/dashboard/**")
                        .hasAnyRole("VIEWER", "ANALYST", "ADMIN")

                        // ✅ User APIs → ADMIN only
                        .requestMatchers("/users/**").hasRole("ADMIN")

                        // ✅ Record write → ADMIN only
                        .requestMatchers(HttpMethod.POST, "/records/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/records/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/records/**").hasRole("ADMIN")

                        // ✅ Everything else authenticated
                        .anyRequest().authenticated()
                )
                // ✅ FIXED FOR SPRING BOOT 4
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withUsername("admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();

        UserDetails analyst = User.withUsername("analyst")
                .password("{noop}password")
                .roles("ANALYST")
                .build();

        UserDetails viewer = User.withUsername("viewer")
                .password("{noop}password")
                .roles("VIEWER")
                .build();

        return new InMemoryUserDetailsManager(admin, analyst, viewer);
    }
}