package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Reporte;

import java.util.List;

public interface IReporteService {
    public List<Reporte> List();
    public void insert(Reporte reporte);
    public void delete(int id);
    public void update(Reporte reporte);
    public Reporte ListId(int id);
}
