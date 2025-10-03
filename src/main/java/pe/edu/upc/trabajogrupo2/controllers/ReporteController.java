package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.ReporteDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.ReporteDTOList;
import pe.edu.upc.trabajogrupo2.entities.Reporte;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IReporteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private IReporteService rS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA','PACIENTE')")
    public List<ReporteDTOList> listarReportes() {
        return rS.List().stream().map(r->{
            ModelMapper m = new ModelMapper();
            return m.map(r, ReporteDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")
    public ResponseEntity<String> insertarReporte(@RequestBody ReporteDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Reporte r = m.map(dto,Reporte.class);
        rS.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reporte "+r.getFechaReporte()
                +" creado");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA')")
    public ResponseEntity<?> listarReportePorId(@PathVariable("id") Integer id) {
        Reporte r = rS.ListId(id);
        if (r == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ReporteDTOList dto = m.map(r, ReporteDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> eliminarReporte(@PathVariable("id") Integer id) {
        Reporte r = rS.ListId(id);
        if (r == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Reporte "+id+" eliminado");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> modificarReporte(@RequestBody ReporteDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Reporte r = m.map(dto,Reporte.class);
        Reporte ex = rS.ListId(r.getIdReporte());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + r.getIdReporte());
        }
        rS.update(r);
        return ResponseEntity.ok("Reporte "+r.getFechaReporte()+" modificado");
    }
}
