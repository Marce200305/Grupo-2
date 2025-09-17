package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Sesiones")
public class Sesiones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSesion;

    @ManyToOne
    @JoinColumn(name = "id_Cita", nullable = false)
    private Citas citas;

    @Column(name = "numero", length = 10, nullable = false)
    private String numeroSesion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicioSesion;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFinSesion;

    public Sesiones() {
    }

    public Sesiones(int idSesion, Citas citas, String numeroSesion, LocalDateTime fechaInicioSesion, LocalDateTime fechaFinSesion) {
        this.idSesion = idSesion;
        this.citas = citas;
        this.numeroSesion = numeroSesion;
        this.fechaInicioSesion = fechaInicioSesion;
        this.fechaFinSesion = fechaFinSesion;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public String getNumeroSesion() {
        return numeroSesion;
    }

    public void setNumeroSesion(String numeroSesion) {
        this.numeroSesion = numeroSesion;
    }

    public LocalDateTime getFechaInicioSesion() {
        return fechaInicioSesion;
    }

    public void setFechaInicioSesion(LocalDateTime fechaInicioSesion) {
        this.fechaInicioSesion = fechaInicioSesion;
    }

    public LocalDateTime getFechaFinSesion() {
        return fechaFinSesion;
    }

    public void setFechaFinSesion(LocalDateTime fechaFinSesion) {
        this.fechaFinSesion = fechaFinSesion;
    }
}