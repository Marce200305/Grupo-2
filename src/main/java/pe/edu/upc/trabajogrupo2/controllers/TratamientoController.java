package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.TratamientoDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.TratamientoDTOList;
import pe.edu.upc.trabajogrupo2.entities.Tratamientos;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ITratamientosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {
    @Autowired
    private ITratamientosService tS;

    @GetMapping
    public List<TratamientoDTOList> listarTratamientos() {
        return tS.List().stream().map(t->{
            ModelMapper m = new ModelMapper();
            return m.map(t, TratamientoDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertarTratamiento(@RequestBody TratamientoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Tratamientos t = m.map(dto, Tratamientos.class);
        tS.insert(t);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tratamiento "+t.getObjetivoTratamiento()
                +" creado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarTratamientoPorId(@PathVariable("id") Integer id) {
        Tratamientos t = tS.ListId(id);
        if (t == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TratamientoDTOList dto = m.map(t, TratamientoDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTratamiento(@PathVariable("id") Integer id) {
        Tratamientos t = tS.ListId(id);
        if (t == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + id);
        }
        tS.delete(id);
        return ResponseEntity.ok("Tratamiento "+id+" eliminado");
    }

    @PutMapping
    public ResponseEntity<String> modificarTratamiento(@RequestBody TratamientoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Tratamientos t = m.map(dto, Tratamientos.class);
        Tratamientos ex = tS.ListId(t.getIdTratamiento());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + t.getIdTratamiento());
        }
        tS.update(t);
        return ResponseEntity.ok("Tratamiento "+t.getObjetivoTratamiento()+" modificado");
    }
}
