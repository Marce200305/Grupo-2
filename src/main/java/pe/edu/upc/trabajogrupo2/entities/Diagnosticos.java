package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Diagnosticos")
public class Diagnosticos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnostico;

    @ManyToOne
    @JoinColumn(name = "idHistorial")
    private Historial historial;

    @Column(name = "fecharegistroDiagnostico", nullable = false)
    private LocalDateTime fechaRegistroDiagnostico;

    @Column(name = "descripcionDiagnostico", length = 50, nullable = false)
    private String descripcionDiagnostico;

    @Column(name = "terapeutaDiagnostico", length = 50, nullable = false)
    private String terapeutaDiagnostico;

    @Column(name = "severidadDiagnostico", length = 50,nullable = false)
    private String severidadDiagnostico;

    @Column(name = "firmaDiagnostico", length = 50,nullable = false)
    private String firmaDiagnostico;

    public Diagnosticos() {
    }

    public Diagnosticos(int idDiagnostico, Historial historial, LocalDateTime fechaRegistroDiagnostico,
                        String descripcionDiagnostico, String terapeutaDiagnostico,
                        String severidadDiagnostico, String firmaDiagnostico) {
        this.idDiagnostico = idDiagnostico;
        this.historial = historial;
        this.fechaRegistroDiagnostico = fechaRegistroDiagnostico;
        this.descripcionDiagnostico = descripcionDiagnostico;
        this.terapeutaDiagnostico = terapeutaDiagnostico;
        this.severidadDiagnostico = severidadDiagnostico;
        this.firmaDiagnostico = firmaDiagnostico;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public LocalDateTime getFechaRegistroDiagnostico() {
        return fechaRegistroDiagnostico;
    }

    public void setFechaRegistroDiagnostico(LocalDateTime fechaRegistroDiagnostico) {
        this.fechaRegistroDiagnostico = fechaRegistroDiagnostico;
    }

    public String getDescripcionDiagnostico() {
        return descripcionDiagnostico;
    }

    public void setDescripcionDiagnostico(String descripcionDiagnostico) {
        this.descripcionDiagnostico = descripcionDiagnostico;
    }

    public String getTerapeutaDiagnostico() {
        return terapeutaDiagnostico;
    }

    public void setTerapeutaDiagnostico(String terapeutaDiagnostico) {
        this.terapeutaDiagnostico = terapeutaDiagnostico;
    }

    public String getSeveridadDiagnostico() {
        return severidadDiagnostico;
    }

    public void setSeveridadDiagnostico(String severidadDiagnostico) {
        this.severidadDiagnostico = severidadDiagnostico;
    }

    public String getFirmaDiagnostico() {
        return firmaDiagnostico;
    }

    public void setFirmaDiagnostico(String firmaDiagnostico) {
        this.firmaDiagnostico = firmaDiagnostico;
    }
}