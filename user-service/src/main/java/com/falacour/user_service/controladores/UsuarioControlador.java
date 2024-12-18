package com.falacour.user_service.controladores;

import com.falacour.user_service.entidadesDTO.UsuarioRequest;
import com.falacour.user_service.entidadesDTO.UsuarioResponse;
import com.falacour.user_service.servicios.UsuarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author feder
 */

@RestController
@RequestMapping("/api/usuario")//ruta a la que se hace la solicitud
@RequiredArgsConstructor //inyeccion de dependencias(SolicitudPagoService)
public class UsuarioControlador {
    
    private final UsuarioService usuarioService;
    
    @PostMapping
    public ResponseEntity<Void> addUsuario(@RequestBody UsuarioRequest usuarioRequest){
            
            //ver como hacer con lo de estado
        
            if(usuarioRequest.getUsername().isEmpty()
                    || usuarioRequest.getPassword().isEmpty()){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            this.usuarioService.addUsuario(usuarioRequest);
            return ResponseEntity.ok().build();
           
    }
    
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAllusuarios(){
        try {
            return ResponseEntity.ok(this.usuarioService.getAllUsuarios());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    
}

