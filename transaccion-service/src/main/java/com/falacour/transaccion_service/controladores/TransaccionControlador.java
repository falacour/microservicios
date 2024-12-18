package com.falacour.transaccion_service.controladores;

import com.falacour.transaccion_service.entidadesDTO.TransaccionRequest;
import com.falacour.transaccion_service.entidadesDTO.TransaccionResponse;
import com.falacour.transaccion_service.servicios.TransaccionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author feder
 */


@RestController
@RequestMapping("/api/transaccion")//ruta a la que se hace la solicitud
@RequiredArgsConstructor //inyeccion de dependencias(SolicitudPagoService)
public class TransaccionControlador {
    
    private final TransaccionService transaccionService;
    
    @PostMapping
    public ResponseEntity<Void> addTransaccion(@RequestBody TransaccionRequest transaccionRequest){
            
            //ver como hacer con lo de estado
        
            if(transaccionRequest.getImporte() <= 0 
                    || transaccionRequest.getDescripcion().isEmpty() 
                    || transaccionRequest.getFecha() == null
                    ){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            this.transaccionService.addTransaccion(transaccionRequest);
            return ResponseEntity.ok().build();
           
    }
    
    @GetMapping
    public ResponseEntity<List<TransaccionResponse>> getAllTransacciones(){
        try {
            return ResponseEntity.ok(this.transaccionService.getAllTransacciones());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    
}
