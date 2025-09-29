package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Videoconferencias;

import java.util.List;

@Repository
public interface IVideoconferenciasRepository extends JpaRepository<Videoconferencias, Integer> {
    @Query("SELECT v FROM Videoconferencias v WHERE v.proveedorVideoconferencia = :proveedorVideoconferencia")
    public List<Videoconferencias> findByProveedor(@Param("proveedorVideoconferencia") String proveedorVideoconferencia);
}
