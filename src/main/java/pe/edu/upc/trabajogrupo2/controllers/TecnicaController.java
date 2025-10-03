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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicas")
public class TecnicaController {
    @Autowired
    private ITecnicasService tS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('TERAPEUTA','PACIENTE')")
    public List<TecnicaDTOList> listarTecnicas() {
        return tS.List().stream().map(t->{
            ModelMapper m = new ModelMapper();
            return m.map(t, TecnicaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")
    public ResponseEntity<String> insertarTecnica(@RequestBody TecnicaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Tecnicas t = m.map(dto, Tecnicas.class);
        tS.insert(t);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tecnica "+t.getNombreTecnica()
                +" creada");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TERAPEUTA','PACIENTE')")
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
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")
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
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")
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

    @GetMapping("/{idSesion}/tecnicas")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<Map<String, Object>> tecnicasEnSesion(@PathVariable("idSesion") int idSesion) {
        List<Object[]> results = tS.tecnicasEnSesion(idSesion);

        List<Map<String, Object>> response = new ArrayList<>();
        for (Object[] row : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("idTecnica", row[0]);
            map.put("nombre", row[1]);
            map.put("descripcion", row[2]);
            response.add(map);
        }

        return response;
    }


}
