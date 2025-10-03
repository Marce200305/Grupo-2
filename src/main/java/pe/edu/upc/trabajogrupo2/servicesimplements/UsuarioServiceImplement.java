package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Usuarios;
import pe.edu.upc.trabajogrupo2.repositories.IUsuarioRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository dR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuarios> List() {
        return dR.findAll();
    }

    @Override
    public void insert(Usuarios usuarios) {
        String encodedPassword = passwordEncoder.encode(usuarios.getPassword());
        usuarios.setPassword(encodedPassword);
        usuarios.setEnabled(true);
        dR.save(usuarios);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Usuarios usuarios) {
        Usuarios existingUser = dR.findById(usuarios.getIdUsuario()).orElse(null);

        if (existingUser != null && !usuarios.getPassword().equals(existingUser.getPassword())) {
            String encodedPassword = passwordEncoder.encode(usuarios.getPassword());
            usuarios.setPassword(encodedPassword);
        }
        dR.save(usuarios);
    }

    @Override
    public Usuarios ListId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public List<String[]> masCitasAgendadas() {
        return dR.masCitasAgendadas();
    }

    @Override
    public List<String[]> ReporteProgresoPaciente() {
        return dR.ReporteProgresoPaciente();
    }

    @Override
    public List<Usuarios> Listarporrol(String nameRole) {
        return dR.findByRoles_NameRole(nameRole);
    }

}