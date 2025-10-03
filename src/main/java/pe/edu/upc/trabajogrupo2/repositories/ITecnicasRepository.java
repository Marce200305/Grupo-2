package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Tecnicas;

import java.util.List;

@Repository
public interface ITecnicasRepository extends JpaRepository<Tecnicas, Integer> {

    @Query(value = "SELECT t.id_tecnica, t.nombre_tecnicas, t.descripcion_tecnicas " +
            "FROM tecnicas t " +
            "WHERE t.id_sesion = :idSesion", nativeQuery = true)
    List<Object[]> tecnicasEnSesion(@Param("idSesion") int idSesion);



}
