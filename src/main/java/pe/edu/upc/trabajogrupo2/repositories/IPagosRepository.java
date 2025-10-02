package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Pagos;

import java.time.LocalDateTime;

@Repository
public interface IPagosRepository extends JpaRepository<Pagos, Integer> {
//    @Query(value = "Select sum(p.monto_pagos) from pagos p", nativeQuery = true)
//    public Double Sumadepagos();

    @Query(value = "SELECT SUM(p.monto_pagos) " +
            "FROM pagos p " +
            "WHERE p.fecha_pagos BETWEEN :fecha1 AND :fecha2 " +
            "AND p.estado_pagos = 'APROBADO'", nativeQuery = true)
    Double RecaudacionPorFechas(LocalDateTime fecha1, LocalDateTime fecha2);
}
