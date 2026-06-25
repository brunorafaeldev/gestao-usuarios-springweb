package com.github.brunorafaeldev.api_web_first_project.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desativa a proteção CSRF para permitir requisições de POST do Postman
                .csrf(csrf -> csrf.disable())
                // Permite carregar a consola do H2 dentro de um iframe
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/users", "POST")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/users", "GET")).hasAnyRole("USERS", "MANAGERS")
                        .requestMatchers(new AntPathRequestMatcher("/managers")).hasRole("MANAGERS")
                        .requestMatchers(new AntPathRequestMatcher("/teste-users")).hasAnyRole("USERS", "MANAGERS")
                        .anyRequest().authenticated())
                .formLogin(form -> form.permitAll())
                // Ativa o Basic Auth para podermos testar diretamente no Postman
                .httpBasic(httpBasic -> {});

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        // TODO: Mudar para BCryptPasswordEncoder quando o projeto for para produção.
        // Usando NoOp apenas para testes locais em texto puro no Postman/H2.1
        return NoOpPasswordEncoder.getInstance();
    }

}
