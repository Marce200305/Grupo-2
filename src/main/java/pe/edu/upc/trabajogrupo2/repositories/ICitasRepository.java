package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Citas;

import java.util.List;

@Repository
public interface ICitasRepository extends JpaRepository<Citas, Integer> {
}
