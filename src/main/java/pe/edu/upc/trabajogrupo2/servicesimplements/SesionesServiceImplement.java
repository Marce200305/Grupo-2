package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Sesiones;
import pe.edu.upc.trabajogrupo2.repositories.ISesionesRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ISesionesService;

import java.util.List;

@Service
public class SesionesServiceImplement implements ISesionesService {
    @Autowired
    private ISesionesRepository dR;
    @Override
    public List<Sesiones> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Sesiones sesiones) {
        dR.save(sesiones);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Sesiones sesiones) {
        dR.save(sesiones);
    }

    @Override
    public Sesiones ListId(int id) {
        return dR.findById(id).orElse(null);
    }
}
