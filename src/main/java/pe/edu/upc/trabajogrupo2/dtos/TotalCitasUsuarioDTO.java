package pe.edu.upc.trabajogrupo2.dtos;

public class TotalCitasUsuarioDTO {
    private String nameUsuario;
    private String apellidoUsuario;
    private int CantidadCitas;

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

    public int getCantidadCitas() {
        return CantidadCitas;
    }

    public void setCantidadCitas(int cantidadCitas) {
        CantidadCitas = cantidadCitas;
    }
}
