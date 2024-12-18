package com.falacour.transaccion_service.entidades;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

/**
 *
 * @author feder
 */

@Entity
@Table(name = "transaccion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private int solicitudPagoID;
    private Double importe; 
    @Temporal(TemporalType.DATE)
    private Date fecha;    
    @ManyToOne(fetch = FetchType.LAZY)  // Relación Muchos a Uno
    @JoinColumn(name = "estado_id")  // La columna de la clave foránea
    private EstadoTransaccion estado;
    private String descripcion;
}
