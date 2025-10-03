package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Tratamientos;

import java.util.List;

public interface ITratamientosService {
    public List<Tratamientos> List();
    public void insert(Tratamientos tratamientos);
    public void delete(int id);
    public void update(Tratamientos tratamientos);
    public Tratamientos ListId(int id);
    public List<Object[]> rankingPacientes();
}
