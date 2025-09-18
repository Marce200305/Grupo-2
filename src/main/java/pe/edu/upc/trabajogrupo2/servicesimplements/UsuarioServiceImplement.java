package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Usuarios;
import pe.edu.upc.trabajogrupo2.repositories.IUsuarioRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository dR;

    @Override
    public List<Usuarios> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Usuarios usuarios) {
        dR.save(usuarios);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Usuarios usuarios) {
        dR.save(usuarios);
    }

    @Override
    public Usuarios ListId(int id) {
        return dR.findById(id).orElse(null);
    }

}
