package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Pagos;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPagosRepository extends JpaRepository<Pagos, Integer> {
//    @Query(value = "Select sum(p.monto_pagos) from pagos p", nativeQuery = true)
//    public Double Sumadepagos();

    @Query(value = "SELECT SUM(p.monto_pagos) " +
            "FROM pagos p " +
            "WHERE p.fecha_pagos BETWEEN :fecha1 AND :fecha2 " +
            "AND p.estado_pagos = 'Completado'", nativeQuery = true)
    Double RecaudacionPorFechas(LocalDateTime fecha1, LocalDateTime fecha2);

    @Query(value = "SELECT AVG(p.monto_pagos) " +
            "FROM pagos p " +
            "WHERE p.fecha_pagos BETWEEN :fecha1 AND :fecha2 " +
            "AND p.estado_pagos = 'Completado'", nativeQuery = true)
    Double PromedioPagosPorFechas(LocalDateTime fecha1, LocalDateTime fecha2);


    @Query(value = "SELECT DATE_TRUNC('month', p.fecha_pagos) AS mes, " +
            "SUM(p.monto_pagos) AS total " +
            "FROM pagos p " +
            "WHERE p.estado_pagos = 'Completado' " +
            "GROUP BY DATE_TRUNC('month', p.fecha_pagos) " +
            "ORDER BY mes", nativeQuery = true)
    List<Object[]> RecaudacionXmes();

    @Query(value = "SELECT u.id_usuario, u.username, SUM(p.monto) AS total_pagado " +
            "FROM pagos p " +
            "JOIN citas c ON p.id_cita = c.id_cita " +
            "JOIN usuarios u ON c.id_usuario = u.id_usuario " +
            "WHERE p.estado_pagos = 'Completado' " +
            "GROUP BY u.id_usuario, u.username " +
            "ORDER BY total_pagado DESC",
            nativeQuery = true)
    List<Object[]> pagosPorPaciente();


}
