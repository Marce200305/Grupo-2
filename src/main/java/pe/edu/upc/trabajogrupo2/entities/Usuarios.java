package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private String nameUsuario;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private String apellidoUsuario;

    @Column(name ="nameUsuario",nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private String gmailUsuario;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private int DNIUsuario;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private String contrasenaUsuario;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private String especialidadUsuario;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private int numerocolegiaturaUsuario;

    @Column(name ="nameUsuario", length = 50,nullable = false)
    private String apoderadoUsuario;

    @ManyToOne
    @JoinColumn(name="idRole")
    private Roles roles;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String nameUsuario, String apellidoUsuario, LocalDate fechaNacimiento, String gmailUsuario, int DNIUsuario, String contrasenaUsuario, String especialidadUsuario, int numerocolegiaturaUsuario, String apoderadoUsuario, Roles roles) {
        this.idUsuario = idUsuario;
        this.nameUsuario = nameUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.gmailUsuario = gmailUsuario;
        this.DNIUsuario = DNIUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.especialidadUsuario = especialidadUsuario;
        this.numerocolegiaturaUsuario = numerocolegiaturaUsuario;
        this.apoderadoUsuario = apoderadoUsuario;
        this.roles = roles;
    }

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
