package com.falacour.user_service.componentes;

import com.falacour.user_service.entidades.Rol;
import com.falacour.user_service.entidades.Usuario;
import com.falacour.user_service.entidadesDTO.RolResponse;
import com.falacour.user_service.entidadesDTO.UsuarioResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author feder
 */

@Component
public class UsuarioMapper {

    public UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .rol(toRolResponse(usuario.getRol()))
                .build();
    }

    public RolResponse toRolResponse(Rol rol) {
        return RolResponse.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();
    }
}