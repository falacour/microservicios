package com.falacour.transaccion_service.servicios;

import com.falacour.transaccion_service.componentes.TransaccionMapper;
import com.falacour.transaccion_service.entidades.Transaccion;
import com.falacour.transaccion_service.entidadesDTO.TransaccionRequest;
import com.falacour.transaccion_service.entidadesDTO.TransaccionResponse;
import com.falacour.transaccion_service.repositorios.EstadoTransaccionRepository;
import com.falacour.transaccion_service.repositorios.TransaccionRepository;
import java.util.List;
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
public class TransaccionService {
    private final TransaccionRepository transaccionRepository;
    private final EstadoTransaccionRepository estadoTransaccionRepository;
    private final TransaccionMapper transaccionMapper;

    public void addTransaccion(TransaccionRequest transaccionRequest) {
        var estado = estadoTransaccionRepository.findById(0)
                .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado con ID: " + 0));
        //cambiar por excepcion personalizada con error 409
        
        var transaccionPago = Transaccion.builder()
                .importe(transaccionRequest.getImporte())
                .fecha(transaccionRequest.getFecha())
                .estado(estado)
                .descripcion(transaccionRequest.getDescripcion())
                .build();

        transaccionRepository.save(transaccionPago);
        log.info("transaccionPago agregada: {}", transaccionPago);
    }

    public List<TransaccionResponse> getAllTransacciones() {
        return transaccionRepository.findAll().stream()
                .map(transaccionMapper::toTransaccionResponse)
                .toList();
    }
}
