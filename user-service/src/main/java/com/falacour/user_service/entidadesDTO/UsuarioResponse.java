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
public class UsuarioResponse {
    private int id; 
    private String username; 
    private String password;
    private RolResponse rol;
}
