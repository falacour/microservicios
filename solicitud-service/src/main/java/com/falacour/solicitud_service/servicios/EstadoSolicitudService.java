package com.falacour.solicitud_service.servicios;

import com.falacour.solicitud_service.entidades.EstadoSolicitud;
import com.falacour.solicitud_service.entidadesDTO.EstadoSolicitudResponse;
import com.falacour.solicitud_service.repositorios.EstadoSolicitudRepository;
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
public class EstadoSolicitudService {
    private final EstadoSolicitudRepository estadoSolicitudRepository;
    
    public EstadoSolicitudResponse getSolicitudPagoById(int idEstadoSolicitud){
            var estadoSolicitud = estadoSolicitudRepository.getReferenceById(idEstadoSolicitud);
            return mapToEstadoSolicitudResponse(estadoSolicitud);
        }
    
    private EstadoSolicitudResponse mapToEstadoSolicitudResponse(EstadoSolicitud estadoSolicitud){
        return EstadoSolicitudResponse.builder()
                .id(estadoSolicitud.getId())
                .codigo(estadoSolicitud.getCodigo())
                .descripcion(estadoSolicitud.getDescripcion())
                .build();    
    }
}
