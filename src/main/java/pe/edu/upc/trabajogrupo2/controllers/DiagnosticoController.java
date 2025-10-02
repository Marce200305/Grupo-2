package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.DiagnosticoDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.DiagnosticoDTOList;
import pe.edu.upc.trabajogrupo2.dtos.UsuarioDTOList;
import pe.edu.upc.trabajogrupo2.entities.Citas;
import pe.edu.upc.trabajogrupo2.entities.Diagnosticos;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IDiagnosticosService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private IDiagnosticosService dS;

    @GetMapping
    public List<DiagnosticoDTOList> listarDiagnosticos() {
        return dS.List().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a, DiagnosticoDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertarDiagnostico(@RequestBody DiagnosticoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Diagnosticos d = m.map(dto,Diagnosticos.class);
        dS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED).body("Diagnostico "+d.getSeveridadDiagnostico()
                +" creado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarDiagnosticoPorId(@PathVariable("id") Integer id) {
        Diagnosticos d = dS.ListId(id);
        if (d == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        DiagnosticoDTOList dto = m.map(d, DiagnosticoDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDiagnostico(@PathVariable("id") Integer id) {
        Diagnosticos d = dS.ListId(id);
        if (d == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        dS.delete(id);
        return ResponseEntity.ok("Diagnostico "+id+" eliminado");
    }

    @PutMapping
    public ResponseEntity<String> modificarDiagnostico(@RequestBody DiagnosticoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Diagnosticos d = m.map(dto,Diagnosticos.class);
        Diagnosticos ex = dS.ListId(d.getIdDiagnostico());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + d.getIdDiagnostico());
        }
        dS.update(d);
        return ResponseEntity.ok("Diagnostico "+d.getSeveridadDiagnostico()+" modificado");
    }
    @GetMapping("/severidad")
    public ResponseEntity<?>buscarseveridad(@RequestParam String severidadDiagnostico){
        List<Diagnosticos> diagnosticos = dS.bucarporeveridad(severidadDiagnostico);

        if(diagnosticos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("No se encontraron reservas con la fecha de buscada:"+severidadDiagnostico);
        }
        List<DiagnosticoDTOList> listaDTO = diagnosticos.stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,DiagnosticoDTOList.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
