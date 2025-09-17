package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Alertas")
public class Alertas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlerta;

    @ManyToOne
    @JoinColumn(name = "id_Cita", nullable = false)
    private Citas citas;

    @Column(name = "canal", length = 1000, nullable = false)
    private String canalAlerta;

    @Column(name = "titulo", length = 200, nullable = false)
    private String tituloAlerta;

    @Column(name = "mensaje", length = 1000, nullable = false)
    private String mensajeAlerta;

    public Alertas() {
    }

    public Alertas(int idAlerta, Citas citas, String canalAlerta, String tituloAlerta, String mensajeAlerta) {
        this.idAlerta = idAlerta;
        this.citas = citas;
        this.canalAlerta = canalAlerta;
        this.tituloAlerta = tituloAlerta;
        this.mensajeAlerta = mensajeAlerta;
    }

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