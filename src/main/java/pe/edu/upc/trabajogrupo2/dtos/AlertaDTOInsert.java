package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Citas;

public class AlertaDTOInsert {
    private int idAlerta;
    private Citas citas;
    private String canalAlerta;
    private String tituloAlerta;
    private String mensajeAlerta;

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public String getCanalAlerta() {
        return canalAlerta;
    }

    public void setCanalAlerta(String canalAlerta) {
        this.canalAlerta = canalAlerta;
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
}
