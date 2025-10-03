package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Citas;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICitasRepository extends JpaRepository<Citas, Integer> {
    @Query("Select c from Citas c where c.fechaCita=:fechaCita")
    public List<Citas>buscarcita(@Param("fechaCita") LocalDate fechaCita);

    @Query("SELECT COUNT(c) FROM Citas c WHERE c.estadoCita = :estadoCita")
    public Double countByEstado(@Param("estadoCita") String estadoCita);

    @Query(value = "SELECT DATE_TRUNC('month', c.fecha_cita) AS mes, COUNT(*) AS total " +
            "FROM citas c " +
            "GROUP BY DATE_TRUNC('month', c.fecha_cita) " +
            "ORDER BY mes", nativeQuery = true)
    List<Object[]> CitasPorMes();

    @Query(value = "SELECT c.id_usuario, COUNT(*) AS total " +
            "FROM citas c " +
            "GROUP BY c.id_usuario " +
            "ORDER BY total DESC", nativeQuery = true)
    List<Object[]> CitasPorUsuario();

    @Query(value = "SELECT c.id_cita, u.name_usuario, u.apellido_usuario, c.estado_cita, c.fecha_cita\n" +
            "FROM citas c\n" +
            "JOIN usuarios u ON c.id_usuario = u.id_usuario\n" +
            "WHERE c.estado_cita = 'Pendiente'\n" +
            "ORDER BY c.fecha_cita ASC", nativeQuery = true)
    public List<String[]> estadoCitasPendientes();
}
