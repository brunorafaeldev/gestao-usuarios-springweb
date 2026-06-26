package com.github.brunorafaeldev.api_web_first_project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.github.brunorafaeldev.api_web_first_project.repository.UsuarioRepository;
import com.github.brunorafaeldev.api_web_first_project.security.TokenService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO body) {
        String username = body.getUsername();
        String password = body.getPassword();

        var usuario = usuarioRepository.findByUsername(username).orElse(null);

        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {

            String token = tokenService.gerarToken(usuario.getUsername());

            return ResponseEntity.ok(Map.of("Autenticado com sucesso com BCrypt!", token));
        }

        return ResponseEntity.status(403).body("Usuário ou senha inválidos!");
    }

}
