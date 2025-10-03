package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.SesionDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.SesionDTOList;
import pe.edu.upc.trabajogrupo2.entities.Sesiones;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ISesionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sesiones")
public class SesionController {
    @Autowired
    private ISesionesService sS;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','TERAPEUTA','PACIENTE')")
    public List<SesionDTOList> listarSesiones() {
        return sS.List().stream().map(s->{
            ModelMapper m = new ModelMapper();
            return m.map(s, SesionDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> insertarSesion(@RequestBody SesionDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Sesiones s = m.map(dto,Sesiones.class);
        sS.insert(s);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sesion "+s.getNumeroSesion()
                +" creada");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<?> listarSesionPorId(@PathVariable("id") Integer id) {
        Sesiones s = sS.ListId(id);
        if (s == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        SesionDTOList dto = m.map(s, SesionDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> eliminarSesion(@PathVariable("id") Integer id) {
        Sesiones s = sS.ListId(id);
        if (s == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        sS.delete(id);
        return ResponseEntity.ok("Sesion "+id+" eliminada");
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> modificarSesion(@RequestBody SesionDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Sesiones s = m.map(dto,Sesiones.class);
        Sesiones ex = sS.ListId(s.getIdSesion());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + s.getIdSesion());
        }
        sS.update(s);
        return ResponseEntity.ok("Sesion "+s.getNumeroSesion()+" modificada");
    }
}
