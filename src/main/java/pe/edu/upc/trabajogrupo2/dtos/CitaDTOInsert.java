package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Usuarios;

import java.time.LocalDateTime;

public class CitaDTOInsert {
    private int idCita;
    private String estadoCita;
    private LocalDateTime fechaCita;
    private String motivoCita;
    private String videoCita;
    private boolean favoritoCita;
    private Usuarios usuarioPrincipal;
    private Usuarios usuarioSeleccionado;


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
