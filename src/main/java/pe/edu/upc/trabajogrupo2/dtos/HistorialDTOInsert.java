package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Usuarios;

import java.sql.Blob;

public class HistorialDTOInsert {
    private int idHistorial;
    private Usuarios usuarios;
    private Blob documentacionHistorial;

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Blob getDocumentacionHistorial() {
        return documentacionHistorial;
    }

    public void setDocumentacionHistorial(Blob documentacionHistorial) {
        this.documentacionHistorial = documentacionHistorial;
    }
}
