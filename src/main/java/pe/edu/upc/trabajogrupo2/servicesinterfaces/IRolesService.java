package pe.edu.upc.trabajogrupo2.servicesinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Roles;
import java.util.List;

public interface IRolesService {
    public List<Roles> List();
    public void insert(Roles roles);
    public void delete(int id);
    public void update(Roles roles);
    public Roles ListId(int id);

}
