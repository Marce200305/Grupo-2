package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.*;
import pe.edu.upc.trabajogrupo2.entities.Pagos;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IPagosService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    private IPagosService pS;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public List<PagoDTOList> listarPagos() {
        return pS.List().stream().map(p->{
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("Ipay")
    @PreAuthorize("hasAnyRole('PACIENTE')")
    public ResponseEntity<String> insertarPago(@RequestBody PagoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Pagos p = m.map(dto,Pagos.class);
        pS.insert(p);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pago "+p.getFechaPago()
                +" creado");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public ResponseEntity<?> listarPagoPorId(@PathVariable("id") Integer id) {
        Pagos p = pS.ListId(id);
        if (p == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PagoDTOList dto = m.map(p, PagoDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public ResponseEntity<String> eliminarPago(@PathVariable("id") Integer id) {
        Pagos p = pS.ListId(id);
        if (p == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        pS.delete(id);
        return ResponseEntity.ok("Pago "+id+" eliminado");
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")

    public ResponseEntity<String> modificarPago(@RequestBody PagoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Pagos p = m.map(dto,Pagos.class);
        Pagos ex = pS.ListId(p.getIdPago());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + p.getIdPago());
        }
        pS.update(p);
        return ResponseEntity.ok("Pago "+p.getFechaPago()+" modificado");
    }
//    @GetMapping("/montos")
//    public ResponseEntity<?> montototal() {
//        Double total = pS.Sumadepagos();
//
//        if (total==0 ) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("No hay registros" );
//        }
//        QueryPagosDTO dto = new QueryPagosDTO();
//        dto.setMontoPago(total.doubleValue());
//        return ResponseEntity.ok(dto);
//    }

    @GetMapping("/recaudacion/{fecha1}/{fecha2}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> recaudacionPorFechas(
            @PathVariable("fecha1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha1,
            @PathVariable("fecha2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha2) {

        Double total = pS.RecaudacionPorFechas(fecha1, fecha2);

        if (total == null || total == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay pagos registrados en el rango de fechas indicado");
        }

        PagoSumaEntreFechasDTO dto = new PagoSumaEntreFechasDTO();
        dto.setMontoRecaudado(total);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/promedio/{fecha1}/{fecha2}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> promedioPagosPorFechas(
            @PathVariable("fecha1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha1,
            @PathVariable("fecha2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha2) {

        Double promedio = pS.PromedioDePagoPorFechas(fecha1, fecha2);

        if (promedio == null || promedio == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay pagos registrados en el rango de fechas indicado");
        }

        PagoPromedioDTO dto = new PagoPromedioDTO();
        dto.setPromedioPagos(promedio);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/recaudacion-mensual")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> recaudacionMensual() {
        List<Object[]> resultados = pS.RecaudacionXmes();

        List<PagoRecaudacionXmesDTO> dtoList = resultados.stream().map(obj -> {
            PagoRecaudacionXmesDTO dto = new PagoRecaudacionXmesDTO();
            dto.setMes(((java.sql.Timestamp) obj[0]).toLocalDateTime().toLocalDate());
            dto.setTotal(((Number) obj[1]).doubleValue());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }


    @GetMapping("/por-paciente")
    public List<PagosPorPacienteDTO> pagosPorPaciente() {
        List<Object[]> lista = pS.PagosPorPaciente();
        List<PagosPorPacienteDTO> listaDTO = new ArrayList<>();

        for (Object[] obj : lista) {
            PagosPorPacienteDTO dto = new PagosPorPacienteDTO();
            dto.setIdUsuario(((Number) obj[0]).intValue());
            dto.setUsername((String) obj[1]);
            dto.setTotalPagado(((Number) obj[2]).doubleValue());
            listaDTO.add(dto);
        }

        return listaDTO;
    }




}
