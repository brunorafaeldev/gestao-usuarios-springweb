package com.github.brunorafaeldev.api_web_first_project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return " Welcome to my Spring Boot Web API - Com Spring Security ";
    }

    @GetMapping("/teste-users")
    @PreAuthorize("hasAnyRole('USERS', 'MANAGERS')")
    public String users() {
        return "Authorized user";
    }

    public String managers() {
        return "Authorized manager";
    }

    
}
