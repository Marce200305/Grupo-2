package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Citas;

import java.time.LocalDateTime;

public class SesionDTOInsert {
    private int idSesion;
    private Citas citas;
    private String numeroSesion;
    private LocalDateTime fechaInicioSesion;
    private LocalDateTime fechaFinSesion;

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
