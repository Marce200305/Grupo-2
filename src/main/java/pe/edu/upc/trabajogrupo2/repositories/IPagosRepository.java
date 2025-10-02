package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Pagos;

@Repository
public interface IPagosRepository extends JpaRepository<Pagos, Integer> {
    @Query(value = "Select sum(p.monto_pagos) from pagos p", nativeQuery = true)
    public Double Sumadepagos();
}
