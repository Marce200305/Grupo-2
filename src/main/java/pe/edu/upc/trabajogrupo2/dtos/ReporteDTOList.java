package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class ReporteDTOList {
    private LocalDateTime fechaReporte;
    private String detalleReporte;
    private int progresoReporte;

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
