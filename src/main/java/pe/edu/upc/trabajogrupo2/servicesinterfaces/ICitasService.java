package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Citas;

import java.util.List;

public interface ICitasService {
    public List<Citas> List();
    public void insert(Citas citas);
    public void delete(int id);
    public void update(Citas citas);
    public Citas ListId(int id);
    public List<Object[]> getPatientsConMasSesiones();
}
