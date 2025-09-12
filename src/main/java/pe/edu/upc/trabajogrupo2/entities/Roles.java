package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    @Column(name = "nameRole", length = 50, nullable = false)
    private String nameRole;

    public Roles(){}

    public Roles(int idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}