package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Pagos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IPagosService {
    public List<Pagos> List();
    public void insert(Pagos pagos);
    public void delete(int id);
    public void update(Pagos pagos);
    public Pagos ListId(int id);
//   public Double Sumadepagos();
    public Double RecaudacionPorFechas(LocalDateTime fecha1, LocalDateTime fecha2);
}
