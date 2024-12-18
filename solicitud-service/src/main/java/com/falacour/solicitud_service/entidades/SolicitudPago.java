package com.falacour.solicitud_service.entidades;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

/**
 *
 * @author feder
 */
@Entity
@Table(name = "solicitud_pago")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitudPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private Double importe; 
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY)  // Relación Muchos a Uno
    @JoinColumn(name = "estado_id")  // La columna de la clave foránea
    private EstadoSolicitud estado;
    private String descripcion;

    @Override
    public String toString() {
        return "SolicitudPago{" + 
                "id=" + id + 
                ", importe=" + importe + 
                ", fecha=" + fecha + 
                ", estado=" + estado.getDescripcion() + 
                ", descripcion=" + descripcion + 
                '}';
    }
    
    
    
}
