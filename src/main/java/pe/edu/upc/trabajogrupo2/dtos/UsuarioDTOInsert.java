package pe.edu.upc.trabajogrupo2.dtos;

import pe.edu.upc.trabajogrupo2.entities.Roles;

import java.time.LocalDate;

public class UsuarioDTOInsert {
    private int idUsuario;
    private String nameUsuario;
    private String apellidoUsuario;
    private LocalDate fechaNacimiento;
    private String gmailUsuario;
    private int DNIUsuario;
    private String contrasenaUsuario;
    private String apoderadoUsuario;
    private Roles roles;

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

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getApoderadoUsuario() {
        return apoderadoUsuario;
    }

    public void setApoderadoUsuario(String apoderadoUsuario) {
        this.apoderadoUsuario = apoderadoUsuario;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
