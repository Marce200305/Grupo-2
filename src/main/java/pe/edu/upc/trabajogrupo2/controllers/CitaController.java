package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.CitaDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.CitaDTOList;
import pe.edu.upc.trabajogrupo2.dtos.QueryPagosDTO;
import pe.edu.upc.trabajogrupo2.dtos.UsuarioDTOList;
import pe.edu.upc.trabajogrupo2.entities.Citas;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ICitasService;

import java.time.LocalDate;
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
        CitaDTOList dto = m.map(c,CitaDTOList.class);
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
    @GetMapping("/busquedafecha")
    public ResponseEntity<?>buscar(@RequestParam LocalDate fechaCita){
        List<Citas> citas = cS.buscarcita(fechaCita);

        if(citas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("No se encontraron reservas con la fecha de buscada:"+fechaCita);
        }
        List<UsuarioDTOList> listaDTO = citas.stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTOList.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
    @GetMapping("/cantidadcitas")
    public ResponseEntity<?> obtenerCantidad(@RequestParam String estadoCta) {
        Double cantidad=cS.contarporestado(estadoCta);

        if (cantidad==0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron dispositivos registrados " );
        }

        CitaDTOList dto = new CitaDTOList();
        dto.setEstadoCita(estadoCta);
        return ResponseEntity.ok(dto);
    }
}
