package com.falacour.transaccion_service.entidadesDTO;

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
public class TransaccionRequest {
    private Double importe; 
    private Date fecha;
    private int estadoId;
    private String descripcion;
}