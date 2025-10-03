package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    private Boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idRol")
    private Roles roles;

    @Column(name = "nameUsuario", length = 50, nullable = false)
    private String nameUsuario;

    @Column(name = "apellidoUsuario", length = 50, nullable = false)
    private String apellidoUsuario;

    @Column(name = "fechaUsuario", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "gmailUsuario", length = 50, nullable = false)
    private String gmailUsuario;

    @Column(name = "DNIUsuario", length = 50, nullable = false)
    private int DNIUsuario;

    @Column(name = "especialidadUsuario", length = 50, nullable = true)
    private String especialidadUsuario;

    @Column(name = "numerocolegiaturaUsuario", length = 50, nullable = true)
    private int numerocolegiaturaUsuario;

    @Column(name = "apoderadoUsuario", length = 50, nullable = true)
    private String apoderadoUsuario;

    public Usuarios() {}

    public Usuarios(int idUsuario, String username, String password, Boolean enabled, Roles roles, String nameUsuario, String apellidoUsuario, LocalDate fechaNacimiento, String gmailUsuario, int DNIUsuario, String especialidadUsuario, int numerocolegiaturaUsuario, String apoderadoUsuario) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.nameUsuario = nameUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.gmailUsuario = gmailUsuario;
        this.DNIUsuario = DNIUsuario;
        this.especialidadUsuario = especialidadUsuario;
        this.numerocolegiaturaUsuario = numerocolegiaturaUsuario;
        this.apoderadoUsuario = apoderadoUsuario;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getNameUsuario() { return nameUsuario; }
    public void setNameUsuario(String nameUsuario) { this.nameUsuario = nameUsuario; }
    public String getApellidoUsuario() { return apellidoUsuario; }
    public void setApellidoUsuario(String apellidoUsuario) { this.apellidoUsuario = apellidoUsuario; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getGmailUsuario() { return gmailUsuario; }
    public void setGmailUsuario(String gmailUsuario) { this.gmailUsuario = gmailUsuario; }
    public int getDNIUsuario() { return DNIUsuario; }
    public void setDNIUsuario(int DNIUsuario) { this.DNIUsuario = DNIUsuario; }
    public String getEspecialidadUsuario() { return especialidadUsuario; }
    public void setEspecialidadUsuario(String especialidadUsuario) { this.especialidadUsuario = especialidadUsuario; }
    public int getNumerocolegiaturaUsuario() { return numerocolegiaturaUsuario; }
    public void setNumerocolegiaturaUsuario(int numerocolegiaturaUsuario) { this.numerocolegiaturaUsuario = numerocolegiaturaUsuario; }
    public String getApoderadoUsuario() { return apoderadoUsuario; }
    public void setApoderadoUsuario(String apoderadoUsuario) { this.apoderadoUsuario = apoderadoUsuario; }


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}