package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Usuarios;

import java.util.List;

public interface IUsuarioService {
    public List<Usuarios> List();
    public void insert(Usuarios usuarios);
    public void delete(int id);
    public void update(Usuarios usuarios);
    public Usuarios ListId(int id);
    public List<String[]> masCitasAgendadas();
    public List<String[]> ReporteProgresoPaciente();
}