package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Sesiones;

public class TecnicaDTOInsert {
    private int idTecnica;
    private String nombreTecnica;
    private String descripcionTecnica;
    private Sesiones sesiones;

    public int getIdTecnica() {
        return idTecnica;
    }

    public void setIdTecnica(int idTecnica) {
        this.idTecnica = idTecnica;
    }

    public String getNombreTecnica() {
        return nombreTecnica;
    }

    public void setNombreTecnica(String nombreTecnica) {
        this.nombreTecnica = nombreTecnica;
    }

    public String getDescripcionTecnica() {
        return descripcionTecnica;
    }

    public void setDescripcionTecnica(String descripcionTecnica) {
        this.descripcionTecnica = descripcionTecnica;
    }

    public Sesiones getSesiones() {
        return sesiones;
    }

    public void setSesiones(Sesiones sesiones) {
        this.sesiones = sesiones;
    }
}
