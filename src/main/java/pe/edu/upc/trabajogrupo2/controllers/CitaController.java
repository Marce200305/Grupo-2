package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.AlertaDTOList;
import pe.edu.upc.trabajogrupo2.dtos.CitaDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.CitaDTOList;
import pe.edu.upc.trabajogrupo2.entities.Citas;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ICitasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private ICitasService cS;

    @GetMapping
    public List<CitaDTOList> listarCitas() {
        return cS.List().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,CitaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertarCita(@RequestBody CitaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Citas c = m.map(dto,Citas.class);
        cS.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cita "+c.getMotivoCita()
                +" creada");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarCitaPorId(@PathVariable("id") Integer id) {
        Citas c = cS.ListId(id);
        if (c == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        AlertaDTOList dto = m.map(c,AlertaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCita(@PathVariable("id") Integer id) {
        Citas c = cS.ListId(id);
        if (c == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        cS.delete(id);
        return ResponseEntity.ok("Cita "+id+" eliminada");
    }

    @PutMapping
    public ResponseEntity<String> modificarCita(@RequestBody CitaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Citas c = m.map(dto,Citas.class);
        Citas ex = cS.ListId(c.getIdCita());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + c.getIdCita());
        }
        cS.update(c);
        return ResponseEntity.ok("Cita "+c.getMotivoCita()+" modificada");
    }
}
