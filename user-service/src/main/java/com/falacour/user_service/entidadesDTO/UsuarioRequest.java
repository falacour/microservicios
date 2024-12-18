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
public class UsuarioRequest {
    private String username; 
    private String password;
    private int rolId;
}