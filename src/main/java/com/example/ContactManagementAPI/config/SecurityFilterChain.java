package com.example.ContactManagementAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@EnableWebSecurity
@Configuration
public class SecurityFilterChain {

    @Bean
    public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> {
            try {
                authz.requestMatchers("/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html").permitAll()
                        .anyRequest().authenticated().and().csrf().disable().formLogin().disable();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        })
                .httpBasic(withDefaults());

        return http.build();
    }
}
