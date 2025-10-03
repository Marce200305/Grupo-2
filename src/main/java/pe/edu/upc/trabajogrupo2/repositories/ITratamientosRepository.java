package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Tratamientos;

import java.util.List;

@Repository
public interface ITratamientosRepository extends JpaRepository<Tratamientos, Integer> {


    @Query(value = "SELECT t.id_tratamiento, u.username, t.plan_tratamientos, " +
            "t.terapeuta_tratamientos, t.progreso_tratamientos " +
            "FROM tratamientos t " +
            "JOIN historial h ON t.id_historial = h.id_historial " +
            "JOIN usuarios u ON h.id_usuario = u.id_usuario " +
            "ORDER BY t.progreso_tratamientos DESC",
            nativeQuery = true)
    List<Object[]> rankingPacientes();

}
