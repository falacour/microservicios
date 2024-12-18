package com.falacour.solicitud_service.repositorios;

import com.falacour.solicitud_service.entidades.EstadoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author feder
 */

@Repository
public interface EstadoSolicitudRepository extends JpaRepository<EstadoSolicitud, Integer>{
    
}
