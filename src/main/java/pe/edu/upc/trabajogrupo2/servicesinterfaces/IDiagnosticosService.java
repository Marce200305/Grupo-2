package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Diagnosticos;

import java.util.List;

public interface IDiagnosticosService {
    public List<Diagnosticos> List();
    public void insert(Diagnosticos diagnosticos);
    public void delete(int id);
    public void update(Diagnosticos diagnosticos);
    public Diagnosticos ListId(int id);
}
