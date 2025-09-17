package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Tratamientos;

import java.time.LocalDateTime;

public class ReporteDTOInsert {
    private int idReporte;
    private Tratamientos tratamiento;
    private LocalDateTime fechaReporte;
    private String detalleReporte;
    private int progresoReporte;

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
