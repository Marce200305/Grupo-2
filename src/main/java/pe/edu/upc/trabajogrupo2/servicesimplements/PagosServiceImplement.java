package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Pagos;
import pe.edu.upc.trabajogrupo2.repositories.IPagosRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IPagosService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagosServiceImplement implements IPagosService {
    @Autowired
    private IPagosRepository dR;
    @Override
    public List<Pagos> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Pagos pagos) {
        dR.save(pagos);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Pagos pagos) {
        dR.save(pagos);
    }

    @Override
    public Pagos ListId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public Double RecaudacionPorFechas(LocalDateTime fecha1, LocalDateTime fecha2) {
        return dR.RecaudacionPorFechas(fecha1, fecha2);
    }

    @Override
    public Double PromedioDePagoPorFechas(LocalDateTime fecha1, LocalDateTime fecha2) {
        return dR.PromedioPagosPorFechas(fecha1, fecha2);
    }

    @Override
    public List<Object[]> RecaudacionXmes() {
        return dR.RecaudacionXmes();
    }
//
//    @Override
//    public Double Sumadepagos() {
//        return dR.Sumadepagos();
//    }

}
