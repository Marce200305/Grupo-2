package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;

    @Column(name = "estadoCita", length = 50, nullable = false)
    private String estadoCita;

    @Column(name = "fechaCita", nullable = false)
    private LocalDateTime fechaCita;

    @Column(name = "motivoCita", length = 50, nullable = false)
    private String motivoCita;

    @Column(name = "videoCita", length = 50,nullable = false)
    private String videoCita;

    @Column(name = "favoritoCita")
    private boolean favoritoCita;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuarioPrincipal;

    @ManyToOne
    @JoinColumn(name = "idUsuarioSeleccionado",nullable = false)
    private Usuarios usuarioSeleccionado;

    public Citas() {
    }

    public Citas(int idCita, String estadoCita, LocalDateTime fechaCita, String motivoCita, String videoCita, boolean favoritoCita, Usuarios usuarioPrincipal, Usuarios usuarioSeleccionado) {
        this.idCita = idCita;
        this.estadoCita = estadoCita;
        this.fechaCita = fechaCita;
        this.motivoCita = motivoCita;
        this.videoCita = videoCita;
        this.favoritoCita = favoritoCita;
        this.usuarioPrincipal = usuarioPrincipal;
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String getVideoCita() {
        return videoCita;
    }

    public void setVideoCita(String videoCita) {
        this.videoCita = videoCita;
    }

    public boolean isFavoritoCita() {
        return favoritoCita;
    }

    public void setFavoritoCita(boolean favoritoCita) {
        this.favoritoCita = favoritoCita;
    }

    public Usuarios getUsuarioPrincipal() {
        return usuarioPrincipal;
    }

    public void setUsuarioPrincipal(Usuarios usuarioPrincipal) {
        this.usuarioPrincipal = usuarioPrincipal;
    }

    public Usuarios getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuarios usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
}