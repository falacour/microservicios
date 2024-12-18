package com.falacour.user_service.entidades;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author feder
 */

@Entity
@Table(name = "rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
}
