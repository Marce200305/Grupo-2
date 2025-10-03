package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajogrupo2.entities.Videoconferencias;

import java.util.List;
import java.util.Map;

public interface IVideoconferenciasService {
    public List<Videoconferencias> List();
    public void insert(Videoconferencias videoconferencias);
    public void delete(int id);
    public void update(Videoconferencias videoconferencias);
    public Videoconferencias ListId(int id);
    public List<Videoconferencias> bucarporproveedor(String proveedorVideoconferencia);
    public List<Object[]> ObtenerVideoConferenciasHoy();

}
