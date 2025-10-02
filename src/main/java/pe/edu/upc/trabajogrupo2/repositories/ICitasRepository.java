package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Citas;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICitasRepository extends JpaRepository<Citas, Integer> {
    @Query("Select c from Citas c where c.fechaCita=:fechaCita")
    public List<Citas>buscarcita(@Param("fechaCita") LocalDate fechaCita);

    @Query("SELECT COUNT(c) FROM Citas c WHERE c.estadoCita = :estadoCita")
    public Double countByEstado(@Param("estadoCita") String estadoCita);
}
