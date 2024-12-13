package com.universidad.usuario_service.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.universidad.usuario_service.Entities.Usuario;
import com.universidad.usuario_service.Repositories.UsuarioRepository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/v1")
public class UsuarioContreoller {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioContreoller(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

/* 
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getObtnerUsuario(@PathVariable Long id) {
        return id;
    }
     */

}
