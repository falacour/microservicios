package com.falacour.solicitud_service.repositorios;

import com.falacour.solicitud_service.entidades.SolicitudPago;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author feder
 */
public interface SolicitudPagoRepository extends JpaRepository<SolicitudPago, Integer>{
    
}
