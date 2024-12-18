package com.falacour.transaccion_service.repositorios;

import com.falacour.transaccion_service.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author feder
 */
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer>{
    
}
