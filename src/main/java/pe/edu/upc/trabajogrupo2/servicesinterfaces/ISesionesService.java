package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Sesiones;

import java.util.List;

public interface ISesionesService {
    public List<Sesiones> List();
    public void insert(Sesiones sesiones);
    public void delete(int id);
    public void update(Sesiones sesiones);
    public Sesiones ListId(int id);
}
