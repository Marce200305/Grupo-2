package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajogrupo2.entities.Alertas;

import java.util.List;

public interface IAlertaService {
    public List<Alertas> List();
    public void insert(Alertas alertas);
    public void delete(int id);
    public void update(Alertas alertas);
    public Alertas ListId(int id);
    public List<Alertas> buscarporcanal(String canalAlerta);
    public List<Object[]> alertasPorCita();
}
