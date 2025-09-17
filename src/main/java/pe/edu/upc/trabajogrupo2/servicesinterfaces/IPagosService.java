package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Pagos;

import java.util.List;

public interface IPagosService {
    public List<Pagos> List();
    public void insert(Pagos pagos);
    public void delete(int id);
    public void update(Pagos pagos);
    public Pagos ListId(int id);
}
