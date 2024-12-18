package com.falacour.transaccion_service.servicios;

import com.falacour.transaccion_service.entidades.EstadoTransaccion;
import com.falacour.transaccion_service.entidadesDTO.EstadoTransaccionResponse;
import com.falacour.transaccion_service.repositorios.EstadoTransaccionRepository;
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
public class EstadoTransaccionService {
    private final EstadoTransaccionRepository estadoTransaccionRepository;
    
    public EstadoTransaccionResponse gettransaccionById(int idEstadoTransaccion){
            var estadoTransaccion = estadoTransaccionRepository.getReferenceById(idEstadoTransaccion);
            return mapToEstadoTransaccionResponse(estadoTransaccion);
        }
    
    private EstadoTransaccionResponse mapToEstadoTransaccionResponse(EstadoTransaccion estadoTransaccion){
        return EstadoTransaccionResponse.builder()
                .id(estadoTransaccion.getId())
                .codigo(estadoTransaccion.getCodigo())
                .descripcion(estadoTransaccion.getDescripcion())
                .build();    
    }
}