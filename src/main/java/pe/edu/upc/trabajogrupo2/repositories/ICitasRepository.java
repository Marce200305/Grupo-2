package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Citas;

import java.util.List;

@Repository
public interface ICitasRepository extends JpaRepository<Citas, Integer> {
    @Query(value = "SELECT u.nombreUsuario, u.apellidoUsuario, COUNT(s.idSesion) AS totalSesiones " +
            "FROM Citas c " +
            "JOIN Usuarios u ON c.idUsuario = u.idUsuario " +
            "JOIN Sesiones s ON c.idCita = s.idCita " +
            "GROUP BY u.idUsuario " +
            "ORDER BY totalSesiones DESC")
            public List<Object[]> getPatientsConMasSesiones();

}
