package pe.edu.upc.trabajogrupo2.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Roles;
import pe.edu.upc.trabajogrupo2.repositories.IRolesRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IRolesService;

import java.util.List;
@Service
public class RolesServiceImplement implements IRolesService {
    @Autowired
    private IRolesRepository dR;

    @Override
    public List<Roles> List() {return dR.findAll();}

    @Override
    public void insert(Roles roles) {
        dR.save(roles);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public void update(Roles roles) {
        dR.save(roles);
    }

    @Override
    public Roles ListId(int id) {
        return dR.findById(id).orElse(null);
    }
}
