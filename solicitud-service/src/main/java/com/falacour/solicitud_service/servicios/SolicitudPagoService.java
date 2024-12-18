package com.falacour.solicitud_service.servicios;

import com.falacour.solicitud_service.componentes.SolicitudPagoMapper;
import com.falacour.solicitud_service.entidades.SolicitudPago;
import com.falacour.solicitud_service.entidadesDTO.SolicitudPagoRequest;
import com.falacour.solicitud_service.entidadesDTO.SolicitudPagoResponse;
import com.falacour.solicitud_service.repositorios.EstadoSolicitudRepository;
import com.falacour.solicitud_service.repositorios.SolicitudPagoRepository;
import jakarta.persistence.EntityNotFoundException;
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
public class SolicitudPagoService {
    private final SolicitudPagoRepository solicitudPagoRepository;
    private final EstadoSolicitudRepository estadoSolicitudRepository;
    private final SolicitudPagoMapper solicitudPagoMapper;

    public void addSolicitudPago(SolicitudPagoRequest solicitudPagoRequest) {
        var estado = estadoSolicitudRepository.findById(0)
                .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado con ID: " + solicitudPagoRequest.getEstadoId()));

        var solicitudPago = SolicitudPago.builder()
                .importe(solicitudPagoRequest.getImporte())
                .fecha(solicitudPagoRequest.getFecha())
                .estado(estado)  
                .descripcion(solicitudPagoRequest.getDescripcion())
                .build();

        solicitudPagoRepository.save(solicitudPago);
        log.info("Solicitud de Pago agregada: {}", solicitudPago);
    }

    public List<SolicitudPagoResponse> getAllSolicitudPago() {
        return solicitudPagoRepository.findAll().stream()
                .map(solicitudPagoMapper::toSolicitudPagoResponse)
                .toList();
    }
    
    // Método para obtener una solicitud de pago por su ID
    public SolicitudPagoResponse getSolicitudPago(int id) {
        return solicitudPagoRepository.findById(id)
                .map(solicitudPagoMapper::toSolicitudPagoResponse) // Si existe, la mapea al DTO
                .orElseThrow(() -> new EntityNotFoundException("Solicitud de pago con ID " + id + " no encontrada"));
    }
}

