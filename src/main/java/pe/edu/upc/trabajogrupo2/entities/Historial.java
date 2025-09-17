package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "Historial")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorial;

    @ManyToOne
    @JoinColumn(name = "id_Usuario", nullable = false)
    private Usuarios usuarios;

    @Column(name = "documentacion", columnDefinition = "BLOB")
    private Blob documentacionHistorial;

    public Historial() {
    }

    public Historial(int idHistorial, Usuarios usuarios, Blob documentacionHistorial) {
        this.idHistorial = idHistorial;
        this.usuarios = usuarios;
        this.documentacionHistorial = documentacionHistorial;
    }

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