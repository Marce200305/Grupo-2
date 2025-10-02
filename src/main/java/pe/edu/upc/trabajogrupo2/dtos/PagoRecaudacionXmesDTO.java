package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDate;

public class PagoRecaudacionXmesDTO {

    private LocalDate mes;
    private Double total;

    public LocalDate getMes() {
        return mes;
    }

    public void setMes(LocalDate mes) {
        this.mes = mes;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
