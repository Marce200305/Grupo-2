package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Historial;

@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer> {
}
