package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Citas;
import pe.edu.upc.trabajogrupo2.repositories.ICitasRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ICitasService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitasServiceImplement implements ICitasService {
    @Autowired
    private ICitasRepository dR;
    @Override
    public List<Citas> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Citas citas) {
        dR.save(citas);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Citas citas) {
        dR.save(citas);
    }

    @Override
    public Citas ListId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public List<Citas> buscarcita(LocalDate fechaCita) {
        return dR.buscarcita(fechaCita);
    }

    @Override
    public Double contarporestado(String estadoCita) {
        return dR.countByEstado(estadoCita);
    }

    @Override
    public List<Object[]> CitasPorMes() {
        return dR.CitasPorMes();
    }

    @Override
    public List<Object[]> CitasPorUsuario() {
        return dR.CitasPorUsuario();
    }

    @Override
    public List<String[]> estadoCitasPendientes() {
        return dR.estadoCitasPendientes();
    }


}
