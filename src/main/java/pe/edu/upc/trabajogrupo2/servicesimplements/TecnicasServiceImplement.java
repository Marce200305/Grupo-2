package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Tecnicas;
import pe.edu.upc.trabajogrupo2.repositories.ITecnicasRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ITecnicasService;

import java.util.List;

@Service
public class TecnicasServiceImplement implements ITecnicasService {
    @Autowired
    private ITecnicasRepository dR;

    @Override
    public List<Tecnicas> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Tecnicas tecnicas) {
        dR.save(tecnicas);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Tecnicas tecnicas) {
        dR.save(tecnicas);
    }

    @Override
    public Tecnicas ListId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public List<Object[]> tecnicasEnSesion(int idSesion) {
        return dR.tecnicasEnSesion(idSesion);
    }


}
