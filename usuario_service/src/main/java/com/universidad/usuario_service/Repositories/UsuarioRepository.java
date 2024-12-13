package com.universidad.usuario_service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universidad.usuario_service.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
