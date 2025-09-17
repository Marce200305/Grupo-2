package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reporte")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReporte;

    @ManyToOne
    @JoinColumn(name = "idTratamiento")
    private Tratamientos tratamiento;

    @Column(name = "fechaReporte",nullable = false)
    private LocalDateTime fechaReporte;

    @Column(name = "detalleReporte", length = 50,nullable = false)
    private String detalleReporte;

    @Column(name = "progresoReporte", nullable = false)
    private int progresoReporte;

    public Reporte() {
    }

    public Reporte(int idReporte, Tratamientos tratamiento, LocalDateTime fechaReporte,
                   String detalleReporte, int progresoReporte) {
        this.idReporte = idReporte;
        this.tratamiento = tratamiento;
        this.fechaReporte = fechaReporte;
        this.detalleReporte = detalleReporte;
        this.progresoReporte = progresoReporte;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public Tratamientos getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamientos tratamiento) {
        this.tratamiento = tratamiento;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getDetalleReporte() {
        return detalleReporte;
    }

    public void setDetalleReporte(String detalleReporte) {
        this.detalleReporte = detalleReporte;
    }

    public int getProgresoReporte() {
        return progresoReporte;
    }

    public void setProgresoReporte(int progresoReporte) {
        this.progresoReporte = progresoReporte;
    }
}