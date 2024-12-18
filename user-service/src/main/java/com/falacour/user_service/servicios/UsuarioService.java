package com.falacour.user_service.servicios;

import com.falacour.user_service.componentes.UsuarioMapper;
import com.falacour.user_service.entidades.Usuario;
import com.falacour.user_service.entidadesDTO.UsuarioRequest;
import com.falacour.user_service.entidadesDTO.UsuarioResponse;
import com.falacour.user_service.repositorios.RolRepository;
import com.falacour.user_service.repositorios.UsuarioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;

    public void addUsuario(UsuarioRequest usuarioRequest) {
        var rol = rolRepository.findById(usuarioRequest.getRolId())
                .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado con ID: " + 0));
        //cambiar por excepcion personalizada con error 409
        
        var transaccionPago = Usuario.builder()
                .username(usuarioRequest.getUsername())
                .password(usuarioRequest.getPassword())
                .rol(rol)
                .build();

        usuarioRepository.save(transaccionPago);
        log.info("transaccionPago agregada: {}", transaccionPago);
    }

    public List<UsuarioResponse> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toUsuarioResponse)
                .toList();
    }
}