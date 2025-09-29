package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Alertas;
import pe.edu.upc.trabajogrupo2.repositories.IAlertasRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IAlertaService;

import java.util.List;

@Service
public class AlertaServiceImplement implements IAlertaService {
    @Autowired
    private IAlertasRepository dR;

    @Override
    public List<Alertas> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Alertas alertas) {
        dR.save(alertas);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Alertas alertas) {
        dR.save(alertas);
    }

    @Override
    public Alertas ListId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public List<Alertas> buscarporcanal(String canalAlerta) {
        return dR.findByCanal(canalAlerta);
    }
}
