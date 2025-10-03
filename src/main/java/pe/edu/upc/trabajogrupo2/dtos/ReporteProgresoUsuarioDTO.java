package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class ReporteProgresoUsuarioDTO {
    private String nameUsuario;
    private String apellidoUsuario;
    private LocalDateTime fechaReporte;
    private String detalleReporte;
    private int progresoReporte;

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
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
