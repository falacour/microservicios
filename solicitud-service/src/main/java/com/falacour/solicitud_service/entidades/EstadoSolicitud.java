package com.falacour.solicitud_service.entidades;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author feder
 */

@Entity
@Table(name = "estado_solicitud")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codigo;
    private String descripcion;
}
