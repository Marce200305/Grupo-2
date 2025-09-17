package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tratamientos")
public class Tratamientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTratamiento;

    @ManyToOne
    @JoinColumn(name = "id_Historial", nullable = false)
    private Historial historial;

    @Column(name = "objetivo", length = 10000, nullable = false)
    private String objetivoTratamiento;

    @Column(name = "plan", length = 10000, nullable = false)
    private String planTratamiento;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicioTratamiento;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFinTratamiento;

    @Column(name = "terapeuta", length = 150, nullable = false)
    private String terapeutaTratamiento;

    @Column(name = "progreso")
    private int progresoTratamiento;

    public Tratamientos() {
    }

    public Tratamientos(int idTratamiento, Historial historial, String objetivoTratamiento,
                        String planTratamiento, LocalDateTime fechaInicioTratamiento,
                        LocalDateTime fechaFinTratamiento, String terapeutaTratamiento,
                        int progresoTratamiento) {
        this.idTratamiento = idTratamiento;
        this.historial = historial;
        this.objetivoTratamiento = objetivoTratamiento;
        this.planTratamiento = planTratamiento;
        this.fechaInicioTratamiento = fechaInicioTratamiento;
        this.fechaFinTratamiento = fechaFinTratamiento;
        this.terapeutaTratamiento = terapeutaTratamiento;
        this.progresoTratamiento = progresoTratamiento;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public String getObjetivoTratamiento() {
        return objetivoTratamiento;
    }

    public void setObjetivoTratamiento(String objetivoTratamiento) {
        this.objetivoTratamiento = objetivoTratamiento;
    }

    public String getPlanTratamiento() {
        return planTratamiento;
    }

    public void setPlanTratamiento(String planTratamiento) {
        this.planTratamiento = planTratamiento;
    }

    public LocalDateTime getFechaInicioTratamiento() {
        return fechaInicioTratamiento;
    }

    public void setFechaInicioTratamiento(LocalDateTime fechaInicioTratamiento) {
        this.fechaInicioTratamiento = fechaInicioTratamiento;
    }

    public LocalDateTime getFechaFinTratamiento() {
        return fechaFinTratamiento;
    }

    public void setFechaFinTratamiento(LocalDateTime fechaFinTratamiento) {
        this.fechaFinTratamiento = fechaFinTratamiento;
    }

    public String getTerapeutaTratamiento() {
        return terapeutaTratamiento;
    }

    public void setTerapeutaTratamiento(String terapeutaTratamiento) {
        this.terapeutaTratamiento = terapeutaTratamiento;
    }

    public int getProgresoTratamiento() {
        return progresoTratamiento;
    }

    public void setProgresoTratamiento(int progresoTratamiento) {
        this.progresoTratamiento = progresoTratamiento;
    }
}