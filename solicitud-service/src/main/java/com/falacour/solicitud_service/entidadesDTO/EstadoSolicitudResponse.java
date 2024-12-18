package com.falacour.solicitud_service.entidadesDTO;

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
@Setter
public class EstadoSolicitudResponse {
    private int id;
    private int codigo;
    private String descripcion;
}
