package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.trabajogrupo2.entities.Usuarios;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Integer> {
    public Usuarios findOneByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Integer user_id);

    @Query(value = "SELECT u.name_usuario, u.apellido_usuario, COUNT(c.id_cita) AS Total_citas\n" +
            "FROM usuarios u\n" +
            "JOIN citas c ON u.id_usuario = c.id_usuario\n" +
            "GROUP BY u.id_usuario\n" +
            "ORDER BY Total_citas DESC", nativeQuery = true)
    public List<String[]> masCitasAgendadas();

    @Query(value = "SELECT u.name_usuario, u.apellido_usuario, r.fecha_reporte, r.detalle_reporte, r.progreso_reporte\n" +
            "FROM usuarios u\n" +
            "JOIN citas c ON u.id_usuario = c.id_usuario\n" +
            "JOIN tratamientos t ON t.id_historial = (\n" +
            "\tSELECT h.id_historial\n" +
            "\tFROM historial h\n" +
            "\tWHERE h.id_usuario = u.id_usuario LIMIT 1\n" +
            ")\n" +
            "JOIN reporte r ON r.id_tratamiento = t.id_tratamiento\n" +
            "ORDER BY u.name_usuario, r.fecha_reporte", nativeQuery = true)
    public List<String[]> ReporteProgresoPaciente();
}