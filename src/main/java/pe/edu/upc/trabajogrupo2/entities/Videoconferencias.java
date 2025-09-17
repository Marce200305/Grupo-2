package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Videoconferencias")
public class Videoconferencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVideoconferencia; // ← PK

    @ManyToOne
    @JoinColumn(name = "idCita")
    private Citas citas;

    @Column(name = "proveedorVideoconferencia", length = 50, nullable = false)
    private String proveedorVideoconferencia;

    @Column(name = "join_urlVideoconferencia", columnDefinition = "TEXT",nullable = false)
    private String joinUrlVideoconferencia;

    @Column(name = "star_urlVideoconferencia", columnDefinition = "TEXT",nullable = false)
    private String starUrlVideoconferencia;

    @Column(name = "pass_apiVideoconferencia", columnDefinition = "JSONB",nullable = false)
    private String passApiVideoconferencia;


    public Videoconferencias() {
    }

    public Videoconferencias(int idVideoconferencia, Citas citas, String proveedorVideoconferencia,
                             String joinUrlVideoconferencia, String starUrlVideoconferencia,
                             String passApiVideoconferencia) {
        this.idVideoconferencia = idVideoconferencia;
        this.citas = citas;
        this.proveedorVideoconferencia = proveedorVideoconferencia;
        this.joinUrlVideoconferencia = joinUrlVideoconferencia;
        this.starUrlVideoconferencia = starUrlVideoconferencia;
        this.passApiVideoconferencia = passApiVideoconferencia;
    }


    public int getIdVideoconferencia() {
        return idVideoconferencia;
    }

    public void setIdVideoconferencia(int idVideoconferencia) {
        this.idVideoconferencia = idVideoconferencia;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public String getProveedorVideoconferencia() {
        return proveedorVideoconferencia;
    }

    public void setProveedorVideoconferencia(String proveedorVideoconferencia) {
        this.proveedorVideoconferencia = proveedorVideoconferencia;
    }

    public String getJoinUrlVideoconferencia() {
        return joinUrlVideoconferencia;
    }

    public void setJoinUrlVideoconferencia(String joinUrlVideoconferencia) {
        this.joinUrlVideoconferencia = joinUrlVideoconferencia;
    }

    public String getStarUrlVideoconferencia() {
        return starUrlVideoconferencia;
    }

    public void setStarUrlVideoconferencia(String starUrlVideoconferencia) {
        this.starUrlVideoconferencia = starUrlVideoconferencia;
    }

    public String getPassApiVideoconferencia() {
        return passApiVideoconferencia;
    }

    public void setPassApiVideoconferencia(String passApiVideoconferencia) {
        this.passApiVideoconferencia = passApiVideoconferencia;
    }
}