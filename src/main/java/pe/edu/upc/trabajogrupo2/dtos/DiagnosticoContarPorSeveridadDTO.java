package pe.edu.upc.trabajogrupo2.dtos;

public class DiagnosticoContarPorSeveridadDTO {

    private String severidad;
    private Long total;

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
