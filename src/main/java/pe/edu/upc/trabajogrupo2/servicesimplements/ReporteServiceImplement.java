package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.trabajogrupo2.entities.Reporte;
import pe.edu.upc.trabajogrupo2.repositories.IReporteRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IReporteService;

import java.util.List;

public class ReporteServiceImplement implements IReporteService {

    @Autowired
    private IReporteRepository dR;
    @Override
    public List<Reporte> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Reporte reporte) {
        dR.save(reporte);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Reporte reporte) {
        dR.save(reporte);
    }

    @Override
    public Reporte ListId(int id) {
        return dR.findById(id).orElse(null);
    }
}
