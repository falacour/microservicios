package com.falacour.transaccion_service.entidadesDTO;

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
public class EstadoTransaccionResponse {
    private int id;
    private int codigo;
    private String descripcion;
}