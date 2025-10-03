package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.TecnicaDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.TecnicaDTOList;
import pe.edu.upc.trabajogrupo2.entities.Tecnicas;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ITecnicasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicas")
public class TecnicaController {
    @Autowired
    private ITecnicasService tS;

    @GetMapping
    @PreAuthorize("hasAnyRole('TERAPEUTA','PACIENTE')")
    public List<TecnicaDTOList> listarTecnicas() {
        return tS.List().stream().map(t->{
            ModelMapper m = new ModelMapper();
            return m.map(t, TecnicaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('TERAPEUTA')")
    public ResponseEntity<String> insertarTecnica(@RequestBody TecnicaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Tecnicas t = m.map(dto, Tecnicas.class);
        tS.insert(t);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tecnica "+t.getNombreTecnica()
                +" creada");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('TERAPEUTA','PACIENTE')")
    public ResponseEntity<?> listarTecnicaPorId(@PathVariable("id") Integer id) {
        Tecnicas t = tS.ListId(id);
        if (t == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TecnicaDTOList dto = m.map(t, TecnicaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('TERAPEUTA')")
    public  ResponseEntity<String> eliminarTecnica(@PathVariable("id") Integer id) {
        Tecnicas t = tS.ListId(id);
        if (t == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        tS.delete(id);
        return ResponseEntity.ok("Tecnica "+id+" eliminada");
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('TERAPEUTA')")
    public ResponseEntity<String> modificarTecnica(@RequestBody TecnicaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Tecnicas t = m.map(dto, Tecnicas.class);
        Tecnicas ex = tS.ListId(t.getIdTecnica());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + t.getIdTecnica());
        }
        tS.update(t);
        return ResponseEntity.ok("Tecnica "+t.getNombreTecnica()+" modificada");
    }
}
