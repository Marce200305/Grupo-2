package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tecnicas")
public class Tecnicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTecnica;

    @Column(name = "nombreTecnicas", length = 10, nullable = false)
    private String nombreTecnica;

    @Column(name = "descripcionTecnicas", length = 50,nullable = false)
    private String descripcionTecnica;

    @ManyToOne
    @JoinColumn(name = "idSesion")
    private Sesiones sesiones;

    public Tecnicas() {
    }

    public Tecnicas(int idTecnica, String nombreTecnica, String descripcionTecnica, Sesiones sesiones) {
        this.idTecnica = idTecnica;
        this.nombreTecnica = nombreTecnica;
        this.descripcionTecnica = descripcionTecnica;
        this.sesiones = sesiones;
    }

    public int getIdTecnica() {
        return idTecnica;
    }

    public void setIdTecnica(int idTecnica) {
        this.idTecnica = idTecnica;
    }

    public String getNombreTecnica() {
        return nombreTecnica;
    }

    public void setNombreTecnica(String nombreTecnica) {
        this.nombreTecnica = nombreTecnica;
    }

    public String getDescripcionTecnica() {
        return descripcionTecnica;
    }

    public void setDescripcionTecnica(String descripcionTecnica) {
        this.descripcionTecnica = descripcionTecnica;
    }

    public Sesiones getSesiones() {
        return sesiones;
    }

    public void setSesiones(Sesiones sesiones) {
        this.sesiones = sesiones;
    }
}