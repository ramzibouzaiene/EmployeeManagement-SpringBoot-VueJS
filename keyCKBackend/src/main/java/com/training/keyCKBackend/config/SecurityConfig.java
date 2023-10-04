package com.training.keyCKBackend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig
{
   private final JwtAuthConverter jwtAuthConverter;
   @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .authorizeHttpRequests()
               .requestMatchers("/all").permitAll()
                  .anyRequest()
                     .authenticated();
       http.oauth2Login(Customizer.withDefaults())
                       .formLogin(Customizer.withDefaults());
       http.cors();

       http
               .oauth2ResourceServer()
                  .jwt()
                     .jwtAuthenticationConverter(jwtAuthConverter);
       http
               .sessionManagement()
                  .sessionCreationPolicy(STATELESS);

       return http.build();
   }

}