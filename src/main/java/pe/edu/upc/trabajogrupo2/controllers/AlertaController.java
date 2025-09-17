package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.AlertaDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.AlertaDTOList;
import pe.edu.upc.trabajogrupo2.entities.Alertas;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IAlertaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {
    @Autowired
    private IAlertaService alertaService;

    @GetMapping
    public List<AlertaDTOList> listarAlertas() {
        return alertaService.List().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,AlertaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertarAlerta(@RequestBody AlertaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Alertas a = m.map(dto,Alertas.class);
        alertaService.insert(a);
        return ResponseEntity.status(HttpStatus.CREATED).body("Alerta "+a.getTituloAlerta()
                +" creada exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarAlertaPorId(@PathVariable("id") Integer id) {
        Alertas a = alertaService.ListId(id);
        if (a == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        AlertaDTOList dto = m.map(a,AlertaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAlerta(@PathVariable("id") Integer id) {
        Alertas a = alertaService.ListId(id);
        if (a == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        alertaService.delete(id);
        return ResponseEntity.ok("Alerta "+id+" eliminada");
    }

    @PutMapping()
    public ResponseEntity<String> modificarAlerta(@RequestBody AlertaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Alertas a = m.map(dto,Alertas.class);
        Alertas ex = alertaService.ListId(a.getIdAlerta());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + a.getIdAlerta());
        }
        alertaService.update(a);
        return ResponseEntity.ok("Alerta "+a.getTituloAlerta()+" modificado");
    }
}
