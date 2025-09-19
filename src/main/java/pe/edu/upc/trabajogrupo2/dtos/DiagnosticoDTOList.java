package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class DiagnosticoDTOList {
    private LocalDateTime fechaRegistroDiagnostico;
    private String descripcionDiagnostico;
    private String terapeutaDiagnostico;
    private String severidadDiagnostico;
    private String firmaDiagnostico;

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
