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
    @JoinColumn(name = "id_Tratamiento", nullable = false)
    private Tratamientos tratamiento;

    @Column(name = "fecha",nullable = false)
    private LocalDateTime fechaReporte;

    @Column(name = "detalle", length = 1000,nullable = false)
    private String detalleReporte;

    @Column(name = "progreso")
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