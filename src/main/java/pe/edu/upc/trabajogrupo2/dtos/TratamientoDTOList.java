package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class TratamientoDTOList {
    private String objetivoTratamiento;
    private String planTratamiento;
    private LocalDateTime fechaInicioTratamiento;
    private LocalDateTime fechaFinTratamiento;
    private String terapeutaTratamiento;
    private int progresoTratamiento;

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
