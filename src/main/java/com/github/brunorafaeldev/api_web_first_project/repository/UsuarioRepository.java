package com.github.brunorafaeldev.api_web_first_project.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.github.brunorafaeldev.api_web_first_project.handler.CampoObrigatorioException;
import com.github.brunorafaeldev.api_web_first_project.model.Usuario;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario) { 

        if (usuario.getLogin() == null)
            throw new CampoObrigatorioException("login");
        if(usuario.getPassword()==null)
            throw new CampoObrigatorioException("password");

        if (usuario.getId() == null) {
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        } else
            System.out.println("UPDATE - Recebendo usuário na camada de respositório");

        System.out.println(usuario);

    }

    public void deletedById(Integer id) {
        System.out.println(String.format("DELETED/id - Recebendo o id: %d para excluir um usuario", id));
        System.err.println(id);

    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("bruno", "password"));
        usuarios.add(new Usuario("larissa", "password"));
        return usuarios;

    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("Find/id - Recebendo id: %d para localizar um usuario", id));
        return new Usuario("Bruno", "password");
    }

    public Usuario findByUsername(String username) {
        System.out.println(String.format("Find/username - Recebendo username: %s para localizar um usuario", username));
        return new Usuario("bruno", "password");

    }

}
