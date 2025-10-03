package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Tratamientos;
import pe.edu.upc.trabajogrupo2.repositories.ITratamientosRepository;
import pe.edu.upc.trabajogrupo2.repositories.IVideoconferenciasRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ITratamientosService;

import java.util.List;

@Service
public class TratamientoServiceImplement implements ITratamientosService {
    @Autowired
    private ITratamientosRepository dR;

    @Override
    public List<Tratamientos> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Tratamientos tratamientos) {
        dR.save(tratamientos);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Tratamientos tratamientos) {
        dR.save(tratamientos);
    }

    @Override
    public Tratamientos ListId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public List<String[]> masTratamientosAsignados() {
        return dR.masTratamientosAsignados();
    }
}
