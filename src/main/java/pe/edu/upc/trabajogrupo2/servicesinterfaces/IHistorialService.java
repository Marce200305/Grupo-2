package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajogrupo2.entities.Historial;

import java.util.List;

public interface IHistorialService {
    public List<Historial> List();
    public void insert(Historial historial);
    public void delete(int id);
    public void update(Historial historial);
    public Historial ListId(int id);
    public List<String> findDocumentacionByUsuarioId(Integer idUsuario);

}
