package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Tecnicas;

import java.util.List;

public interface ITecnicasService {
    public List<Tecnicas> List();
    public void insert(Tecnicas tecnicas);
    public void delete(int id);
    public void update(Tecnicas tecnicas);
    public Tecnicas ListId(int id);
    public List<Object[]> tecnicasEnSesion(int idSesion);

}
