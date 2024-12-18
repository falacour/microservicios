package com.falacour.solicitud_service.controladores;

import com.falacour.solicitud_service.entidadesDTO.SolicitudPagoRequest;
import com.falacour.solicitud_service.entidadesDTO.SolicitudPagoResponse;
import com.falacour.solicitud_service.servicios.SolicitudPagoService;
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
@RequestMapping("/api/solicitudPago")//ruta a la que se hace la solicitud
@RequiredArgsConstructor //inyeccion de dependencias(SolicitudPagoService)
public class SolicitudPagoControlador {
    
    private final SolicitudPagoService solicitudPagoService;
    
    @PostMapping
    public ResponseEntity<Void> addSolicitudPago(@RequestBody SolicitudPagoRequest solicitudPagoRequest){
            
            //ver como hacer con lo de estado
        
            if(solicitudPagoRequest.getImporte() <= 0 
                    || solicitudPagoRequest.getDescripcion().isEmpty() 
                    || solicitudPagoRequest.getFecha() == null
                    ){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            this.solicitudPagoService.addSolicitudPago(solicitudPagoRequest);
            return ResponseEntity.ok().build();
           
    }
    
    @GetMapping
    public ResponseEntity<List<SolicitudPagoResponse>> getAllSolicitudPago(){
        try {
            return ResponseEntity.ok(this.solicitudPagoService.getAllSolicitudPago());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    
    // Obtener una solicitud de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudPagoResponse> getSolicitudPago(@PathVariable int id) {
        try {
            SolicitudPagoResponse solicitudPagoResponse = this.solicitudPagoService.getSolicitudPago(id);
            return ResponseEntity.ok(solicitudPagoResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();// Devuelve 404 si no se encuentra
        }
    }
    
}
