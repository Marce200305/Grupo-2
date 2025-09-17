package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Citas;

public class VideoconferenciaDTOInsert {
    private int idVideoconferencia;
    private Citas citas;
    private String proveedorVideoconferencia;
    private String joinUrlVideoconferencia;
    private String starUrlVideoconferencia;
    private String passApiVideoconferencia;

    public int getIdVideoconferencia() {
        return idVideoconferencia;
    }

    public void setIdVideoconferencia(int idVideoconferencia) {
        this.idVideoconferencia = idVideoconferencia;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public String getProveedorVideoconferencia() {
        return proveedorVideoconferencia;
    }

    public void setProveedorVideoconferencia(String proveedorVideoconferencia) {
        this.proveedorVideoconferencia = proveedorVideoconferencia;
    }

    public String getJoinUrlVideoconferencia() {
        return joinUrlVideoconferencia;
    }

    public void setJoinUrlVideoconferencia(String joinUrlVideoconferencia) {
        this.joinUrlVideoconferencia = joinUrlVideoconferencia;
    }

    public String getStarUrlVideoconferencia() {
        return starUrlVideoconferencia;
    }

    public void setStarUrlVideoconferencia(String starUrlVideoconferencia) {
        this.starUrlVideoconferencia = starUrlVideoconferencia;
    }

    public String getPassApiVideoconferencia() {
        return passApiVideoconferencia;
    }

    public void setPassApiVideoconferencia(String passApiVideoconferencia) {
        this.passApiVideoconferencia = passApiVideoconferencia;
    }
}
