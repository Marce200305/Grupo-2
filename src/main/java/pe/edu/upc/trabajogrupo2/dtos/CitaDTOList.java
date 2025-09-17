package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDateTime;

public class CitaDTOList {
    private String estadoCita;
    private LocalDateTime fechaCita;
    private String motivoCita;
    private String videoCita;
    private boolean favoritoCita;

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
}
