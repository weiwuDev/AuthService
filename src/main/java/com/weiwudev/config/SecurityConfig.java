package com.weiwudev.config;

import com.weiwudev.encoders.CustomPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;


@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    private final ServerSecurityContextRepository securityContextRepository = new WebSessionServerSecurityContextRepository();

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        return http.securityContextRepository(securityContextRepository)
                .authorizeExchange()
                .pathMatchers("/logout", "/register").permitAll()
                .pathMatchers("/login").hasAuthority("ROLE_USER")
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .build();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
       // return new CustomPasswordEncoder();
        return new BCryptPasswordEncoder(10);
    }
}
