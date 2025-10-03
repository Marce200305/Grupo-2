package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class AlertaPorCitaDTO {


    private int idCita;
    private LocalDateTime fechaCita;
    private String tituloAlerta;
    private String mensajeAlerta;
    private String canalAlerta;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getTituloAlerta() {
        return tituloAlerta;
    }

    public void setTituloAlerta(String tituloAlerta) {
        this.tituloAlerta = tituloAlerta;
    }

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    public void setMensajeAlerta(String mensajeAlerta) {
        this.mensajeAlerta = mensajeAlerta;
    }

    public String getCanalAlerta() {
        return canalAlerta;
    }

    public void setCanalAlerta(String canalAlerta) {
        this.canalAlerta = canalAlerta;
    }
}
