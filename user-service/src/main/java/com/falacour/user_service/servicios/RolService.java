package com.falacour.user_service.servicios;

import com.falacour.user_service.entidades.Rol;
import com.falacour.user_service.entidadesDTO.RolResponse;
import com.falacour.user_service.repositorios.RolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author feder
 */
    
@Service
@RequiredArgsConstructor
@Slf4j
public class RolService {
    private final RolRepository rolRepository;
    
    public RolResponse gettransaccionById(int idEstadoTransaccion){
            var estadoTransaccion = rolRepository.getReferenceById(idEstadoTransaccion);
            return mapToRolResponse(estadoTransaccion);
        }
    
    private RolResponse mapToRolResponse(Rol rol){
        return RolResponse.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();    
    }
}