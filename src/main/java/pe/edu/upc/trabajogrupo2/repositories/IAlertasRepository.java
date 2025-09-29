package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Alertas;

import java.util.List;

@Repository
public interface IAlertasRepository extends JpaRepository<Alertas, Integer> {
    @Query("SELECT a FROM Alertas a WHERE a.canalAlerta = :canalAlerta")
    public List<Alertas> findByCanal(@Param("canalAlerta") String canalAlerta);
}
