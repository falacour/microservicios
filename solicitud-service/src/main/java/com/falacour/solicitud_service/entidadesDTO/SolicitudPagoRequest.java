package com.falacour.solicitud_service.entidadesDTO;

import java.util.Date;
import lombok.*;

/**
 *
 * @author feder
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SolicitudPagoRequest {
    private Double importe; 
    private Date fecha;
    private int estadoId;
    private String descripcion;
}
