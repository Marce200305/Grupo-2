package pe.edu.upc.trabajogrupo2.dtos;

public class TratamientosAsignadosDTO {
    private String terapeutaTratamiento;
    private int CantidadTratamientos;

    public String getTerapeutaTratamiento() {
        return terapeutaTratamiento;
    }

    public void setTerapeutaTratamiento(String terapeutaTratamiento) {
        this.terapeutaTratamiento = terapeutaTratamiento;
    }

    public int getCantidadTratamientos() {
        return CantidadTratamientos;
    }

    public void setCantidadTratamientos(int cantidadTratamientos) {
        CantidadTratamientos = cantidadTratamientos;
    }
}
