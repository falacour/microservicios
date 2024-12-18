package com.falacour.transaccion_service.entidades;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author feder
 */

@Entity
@Table(name = "estado_transaccion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codigo;
    private String descripcion;
}
