package com.falacour.transaccion_service.repositorios;

import com.falacour.transaccion_service.entidades.EstadoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author feder
 */

@Repository
public interface EstadoTransaccionRepository extends JpaRepository<EstadoTransaccion, Integer>{
    
}
