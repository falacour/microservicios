package com.falacour.transaccion_service.componentes;

import com.falacour.transaccion_service.entidades.EstadoTransaccion;
import com.falacour.transaccion_service.entidades.Transaccion;
import com.falacour.transaccion_service.entidadesDTO.TransaccionResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author feder
 */

@Component
public class TransaccionMapper {

    public TransaccionResponse toTransaccionResponse(Transaccion transaccion) {
        return TransaccionResponse.builder()
                .id(transaccion.getId())
                .importe(transaccion.getImporte())
                .fecha(transaccion.getFecha())
                .estadoTransaccionID(transaccion.getSolicitudPagoID())
                .descripcion(transaccion.getDescripcion())
                .build();
    } 
}