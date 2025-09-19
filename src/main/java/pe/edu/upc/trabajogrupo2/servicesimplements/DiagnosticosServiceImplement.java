package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Diagnosticos;
import pe.edu.upc.trabajogrupo2.repositories.IDiagnosticosRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IDiagnosticosService;

import java.util.List;

@Service
public class DiagnosticosServiceImplement implements IDiagnosticosService {

    @Autowired
    private IDiagnosticosRepository dR;
    @Override
    public List<Diagnosticos> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Diagnosticos diagnosticos) {
        dR.save(diagnosticos);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Diagnosticos diagnosticos) {
        dR.save(diagnosticos);
    }

    @Override
    public Diagnosticos ListId(int id) {
        return dR.findById(id).orElse(null);
    }
}
