package com.github.brunorafaeldev.api_web_first_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return " Welcome to my Spring Boot Web API ";
    }
    
}
