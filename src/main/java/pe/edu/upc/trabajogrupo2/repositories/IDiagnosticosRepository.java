package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Diagnosticos;

import java.util.List;

@Repository
public interface IDiagnosticosRepository extends JpaRepository<Diagnosticos, Integer> {
    @Query("SELECT d FROM Diagnosticos d WHERE d.severidadDiagnostico = :severidadDiagnostico")
    public List<Diagnosticos> findBySeveridad(@Param("severidadDiagnostico") String severidadDiagnostico);
}
