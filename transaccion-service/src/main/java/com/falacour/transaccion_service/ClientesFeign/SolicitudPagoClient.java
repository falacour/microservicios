package com.falacour.transaccion_service.ClientesFeign;

import com.falacour.transaccion_service.entidadesDTO.SolicitudPagoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author feder
 */

@FeignClient(name = "solicitud-service")
public interface SolicitudPagoClient {
    @GetMapping("/api/solicitudPago/{id}")
    SolicitudPagoResponse obtenerSolicitudPago(@PathVariable("id") int id);
}
