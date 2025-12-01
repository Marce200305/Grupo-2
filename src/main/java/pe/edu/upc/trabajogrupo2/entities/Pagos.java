package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @ManyToOne
    @JoinColumn(name = "id_Cita")
    private Citas citas;

    @Column(name = "montoPagos", nullable = false)
    private double montoPago;

    @Column(name = "passapiPagos", columnDefinition = "TEXT",nullable = false)
    private String passApiPago;

    @Column(name = "fechaPagos", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "estadoPagos", length = 30, nullable = false)
    private String estadoPago;

    public Pagos() {
    }

    public Pagos(int idPago, Citas citas, double montoPago, String passApiPago, LocalDateTime fechaPago, String estadoPago) {
        this.idPago = idPago;
        this.citas = citas;
        this.montoPago = montoPago;
        this.passApiPago = passApiPago;
        this.fechaPago = fechaPago;
        this.estadoPago = estadoPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public String getPassApiPago() {
        return passApiPago;
    }

    public void setPassApiPago(String passApiPago) {
        this.passApiPago = passApiPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}