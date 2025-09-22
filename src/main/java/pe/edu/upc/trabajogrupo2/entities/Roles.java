package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "nameRole", length = 50, nullable = false)
    private String nameRole;

    public Roles(){}

    public Roles(int idRol, String nameRole) {
        this.idRol = idRol;
        this.nameRole = nameRole;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}