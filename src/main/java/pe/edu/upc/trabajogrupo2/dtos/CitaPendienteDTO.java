package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class CitaPendienteDTO {

    private Integer idCita;
    private String estado;
    private LocalDateTime fecha;

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
