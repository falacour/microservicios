package com.falacour.solicitud_service.componentes;

import com.falacour.solicitud_service.entidades.SolicitudPago;
import com.falacour.solicitud_service.entidadesDTO.SolicitudPagoResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author feder
 */
@Component
public class SolicitudPagoMapper {

    public SolicitudPagoResponse toSolicitudPagoResponse(SolicitudPago solicitudPago) {
        return SolicitudPagoResponse.builder()
                .id(solicitudPago.getId())
                .importe(solicitudPago.getImporte())
                .fecha(solicitudPago.getFecha())
                .estadoSolicitudID(solicitudPago.getEstado().getId())
                .descripcion(solicitudPago.getDescripcion())
                .build();
    }
}

