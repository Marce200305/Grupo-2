package pe.edu.upc.trabajogrupo2.controllers;

import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.TratamientoDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.TratamientoDTOList;
import pe.edu.upc.trabajogrupo2.dtos.TratamientosAsignadosDTO;
import pe.edu.upc.trabajogrupo2.entities.Tratamientos;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ITratamientosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {
    @Autowired
    private ITratamientosService tS;

    @GetMapping
    @PreAuthorize("hasAnyRole('TERAPEUTA','PACIENTE')")
    public List<TratamientoDTOList> listarTratamientos() {
        return tS.List().stream().map(t->{
            ModelMapper m = new ModelMapper();
            return m.map(t, TratamientoDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> insertarTratamiento(@RequestBody TratamientoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Tratamientos t = m.map(dto, Tratamientos.class);
        tS.insert(t);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tratamiento "+t.getObjetivoTratamiento()
                +" creado");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('TERAPEUTA','PACIENTE')")
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
    @PreAuthorize("hasAnyRole('TERAPEUTA')")
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
    @PreAuthorize("hasAnyRole('TERAPEUTA')")
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

    @GetMapping("/tratamientos-terapeuta")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> masTratamientosAsignados(){
        List<TratamientosAsignadosDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = tS.masTratamientosAsignados();
        for(String[] s:fila)
        {
            TratamientosAsignadosDTO dto = new TratamientosAsignadosDTO();
            dto.setTerapeutaTratamiento(s[0]);
            dto.setCantidadTratamientos(Integer.parseInt(s[1]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }
}
