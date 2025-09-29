package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Historial;

import java.util.List;

@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer> {
    @Query(value = "SELECT h.documentacion_historial " +
            "FROM historial h " +
            "JOIN usuarios u ON u.id_usuario = h.id_usuario " +
            "WHERE u.id_usuario = :idUsuario " +
            "GROUP BY h.documentacion_historial", nativeQuery = true)
    public List<String> findDocumentacionByUsuarioId(@Param("idUsuario") Integer idUsuario);
}
