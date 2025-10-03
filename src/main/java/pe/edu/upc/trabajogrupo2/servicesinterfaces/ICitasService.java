package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajogrupo2.entities.Citas;

import java.time.LocalDate;
import java.util.List;

public interface ICitasService {
    public List<Citas> List();
    public void insert(Citas citas);
    public void delete(int id);
    public void update(Citas citas);
    public Citas ListId(int id);
    public List<Citas>buscarcita(LocalDate fechaCita);
    public Double contarporestado( String estadoCita);
    public List<Object[]> CitasPorMes();
    public List<Object[]> CitasPorUsuario();
    public List<Object[]> CitasPendientes();
    public List<String[]> estadoCitasPendientes();

}
