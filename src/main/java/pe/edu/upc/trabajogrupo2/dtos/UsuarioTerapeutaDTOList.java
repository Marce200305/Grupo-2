package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Roles;

import java.time.LocalDate;

public class UsuarioTerapeutaDTOList {

    private int idUsuario;
    private String nameUsuario;
    private String apellidoUsuario;
    private String especialidadUsuario;
    private int numerocolegiaturaUsuario;
    private LocalDate fechaNacimiento;
    private String gmailUsuario;
    private int DNIUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEspecialidadUsuario() {
        return especialidadUsuario;
    }

    public void setEspecialidadUsuario(String especialidadUsuario) {
        this.especialidadUsuario = especialidadUsuario;
    }

    public int getNumerocolegiaturaUsuario() {
        return numerocolegiaturaUsuario;
    }

    public void setNumerocolegiaturaUsuario(int numerocolegiaturaUsuario) {
        this.numerocolegiaturaUsuario = numerocolegiaturaUsuario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGmailUsuario() {
        return gmailUsuario;
    }

    public void setGmailUsuario(String gmailUsuario) {
        this.gmailUsuario = gmailUsuario;
    }

    public int getDNIUsuario() {
        return DNIUsuario;
    }

    public void setDNIUsuario(int DNIUsuario) {
        this.DNIUsuario = DNIUsuario;
    }

}
