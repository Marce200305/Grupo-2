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


    @Query(value = "SELECT c.id_cita, c.fecha_cita, a.titulo_alerta, a.mensaje_alerta, a.canal_alerta " +
            "FROM citas c " +
            "JOIN alertas a ON c.id_cita = a.id_cita " +
            "ORDER BY c.fecha_cita", nativeQuery = true)
    List<Object[]> alertasPorCita();


}
