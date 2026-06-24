package com.github.brunorafaeldev.api_web_first_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.brunorafaeldev.api_web_first_project.model.Usuario;
import com.github.brunorafaeldev.api_web_first_project.repository.UsuarioRepository;

@RestController

// Obs. Podemos usar o @RequestMapping para eliminar o parâmetro ("/users") das
// requisições

public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/users")
    public List<Usuario> getUsers() {
        return repository.findAll();

    }

    @GetMapping("/users/{username}")
    public Usuario getOneUsuario(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    // Obs. As requisições HTTP só realizam métodos Get, para realizar um delete ou
    // Post, precisamos de um Cliente HTTP. (Podemos usar o Postman)

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deletedById(id);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

    @PutMapping
    public void putuser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

}
