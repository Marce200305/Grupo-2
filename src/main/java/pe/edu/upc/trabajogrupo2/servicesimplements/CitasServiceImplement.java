package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.trabajogrupo2.entities.Citas;
import pe.edu.upc.trabajogrupo2.repositories.ICitasRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ICItasService;

import java.util.List;

public class CitasServiceImplement implements ICItasService {

    @Autowired
    private ICitasRepository dR;
    @Override
    public List<Citas> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Citas citas) {
        dR.save(citas);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Citas citas) {
        dR.save(citas);
    }

    @Override
    public Citas ListId(int id) {
        return dR.findById(id).orElse(null);
    }
}
