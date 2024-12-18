package com.falacour.user_service.entidadesDTO;

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
public class RolResponse {
    private int id;
    private String nombre;
}