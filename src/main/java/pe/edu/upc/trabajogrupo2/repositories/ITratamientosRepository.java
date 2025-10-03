package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Tratamientos;

import java.util.List;

@Repository
public interface ITratamientosRepository extends JpaRepository<Tratamientos, Integer> {

    @Query(value = "SELECT t.terapeuta_tratamientos, COUNT(t.id_tratamiento) AS Total_tratamientos\n" +
            "FROM tratamientos t\n" +
            "GROUP BY t.terapeuta_tratamientos\n" +
            "ORDER BY Total_tratamientos DESC", nativeQuery = true)
    public List<String[]> masTratamientosAsignados();
}
