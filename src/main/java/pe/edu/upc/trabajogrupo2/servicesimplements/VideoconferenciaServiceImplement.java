package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Videoconferencias;
import pe.edu.upc.trabajogrupo2.repositories.IVideoconferenciasRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IVideoconferenciasService;

import java.util.List;

@Service
public class VideoconferenciaServiceImplement implements IVideoconferenciasService {
    @Autowired
    private IVideoconferenciasRepository dR;

    @Override
    public List<Videoconferencias> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Videoconferencias videoconferencias) {
        dR.save(videoconferencias);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Videoconferencias videoconferencias) {
        dR.save(videoconferencias);
    }

    @Override
    public Videoconferencias ListId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public List<Videoconferencias> bucarporproveedor(String proveedorVideoconferencia) {
        return dR.findByProveedor(proveedorVideoconferencia);
    }
}
