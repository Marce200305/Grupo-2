package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "nameRole"})}) // <- CAMBIADO
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nameRole", length = 50, nullable = false)
    private String nameRole;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuarios user;

    public Roles() {}

    public Roles(int idRol, String nameRole) {
        this.idRol = idRol;
        this.nameRole = nameRole;
    }

    // Métodos getters y setters
    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }
    public String getNameRole() { return nameRole; }
    public void setNameRole(String nameRole) { this.nameRole = nameRole; }
    public Usuarios getUser() { return user; }
    public void setUser(Usuarios user) { this.user = user; }
}