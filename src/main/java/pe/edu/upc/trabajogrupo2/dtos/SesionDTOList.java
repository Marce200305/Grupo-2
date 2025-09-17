package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class SesionDTOList {
    private String numeroSesion;
    private LocalDateTime fechaInicioSesion;
    private LocalDateTime fechaFinSesion;

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
