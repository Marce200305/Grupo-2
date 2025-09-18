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
    @JoinColumn(name = "idUsuario")
    private Usuarios usuarios;

    @Column(name = "documentacionHistorial",length= 50,nullable = false)
    private String documentacionHistorial;

    public Historial() {
    }

    public Historial(int idHistorial, Usuarios usuarios, String documentacionHistorial) {
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

    public String getDocumentacionHistorial() {
        return documentacionHistorial;
    }

    public void setDocumentacionHistorial(String documentacionHistorial) {
        this.documentacionHistorial = documentacionHistorial;
    }
}