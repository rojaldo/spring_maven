package com.example.demo.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.example.demo.user.Permission.ADMIN_CREATE;
import static com.example.demo.user.Permission.ADMIN_DELETE;
import static com.example.demo.user.Permission.ADMIN_READ;
import static com.example.demo.user.Permission.ADMIN_UPDATE;
import static com.example.demo.user.Permission.MANAGER_CREATE;
import static com.example.demo.user.Permission.MANAGER_DELETE;
import static com.example.demo.user.Permission.MANAGER_READ;
import static com.example.demo.user.Permission.MANAGER_UPDATE;
import static com.example.demo.user.Role.ADMIN;
import static com.example.demo.user.Role.MANAGER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers(
            "/api/v1/auth/**",
            "/configuration/ui",
            "/configuration/security")
        .permitAll()
        .requestMatchers(GET, "/api/v1/users/**").permitAll()
        .requestMatchers(POST, "/api/v1/users/**").authenticated()
        .requestMatchers(PUT, "/api/v1/users/**").authenticated()
        .requestMatchers(DELETE, "/api/v1/users/**").authenticated()
        .anyRequest()
        .permitAll()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/api/v1/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());

    return http.build();
  }
}
