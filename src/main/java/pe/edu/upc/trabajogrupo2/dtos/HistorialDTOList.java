package pe.edu.upc.trabajogrupo2.dtos;

import java.sql.Blob;

public class HistorialDTOList {
    private Blob documentacionHistorial;

    public Blob getDocumentacionHistorial() {
        return documentacionHistorial;
    }

    public void setDocumentacionHistorial(Blob documentacionHistorial) {
        this.documentacionHistorial = documentacionHistorial;
    }
}
