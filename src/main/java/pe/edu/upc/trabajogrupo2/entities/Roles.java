package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "nameRole", length = 50, nullable = false)
    private String nameRole;


    public Roles() {}

    public Long getIdRol() { return idRol; }
    public void setIdRol(Long idRol) { this.idRol = idRol; }
    public String getNameRole() { return nameRole; }
    public void setNameRole(String nameRole) { this.nameRole = nameRole; }
}