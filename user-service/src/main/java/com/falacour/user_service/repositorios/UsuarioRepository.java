package com.falacour.user_service.repositorios;

import com.falacour.user_service.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author feder
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
