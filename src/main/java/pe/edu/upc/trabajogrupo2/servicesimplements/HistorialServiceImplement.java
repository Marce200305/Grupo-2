package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.trabajogrupo2.entities.Historial;
import pe.edu.upc.trabajogrupo2.repositories.IHistorialRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IHistorialService;

import java.util.List;

public class HistorialServiceImplement implements IHistorialService {

    @Autowired
    private IHistorialRepository dR;
    @Override
    public List<Historial> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Historial historial) {
        dR.save(historial);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Historial historial) {
        dR.save(historial);
    }

    @Override
    public Historial ListId(int id) {
        return dR.findById(id).orElse(null);
    }
}
