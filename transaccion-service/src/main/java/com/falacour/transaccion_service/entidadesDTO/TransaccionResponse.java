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
@Setter
public class TransaccionResponse {
    private int id; 
    private Double importe; 
    private Date fecha;
    private int estadoTransaccionID;
    private String descripcion;
}