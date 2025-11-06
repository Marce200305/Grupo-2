package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.DiagnosticoContarPorSeveridadDTO;
import pe.edu.upc.trabajogrupo2.dtos.DiagnosticoDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.DiagnosticoDTOList;
import pe.edu.upc.trabajogrupo2.dtos.UsuarioDTOList;
import pe.edu.upc.trabajogrupo2.entities.Citas;
import pe.edu.upc.trabajogrupo2.entities.Diagnosticos;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IDiagnosticosService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private IDiagnosticosService dS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA','PACIENTE')")

    public List<DiagnosticoDTOList> listarDiagnosticos() {
        return dS.List().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a, DiagnosticoDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")

    public ResponseEntity<String> insertarDiagnostico(@RequestBody DiagnosticoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Diagnosticos d = m.map(dto,Diagnosticos.class);
        dS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED).body("Diagnostico "+d.getSeveridadDiagnostico()
                +" creado");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA')")

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
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")

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
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")
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
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA')")

    public ResponseEntity<?>buscarseveridad(@RequestParam String severidadDiagnostico,
                                            @RequestParam String descripcionDiagnostico){
        List<Diagnosticos> diagnosticos = dS.bucarporeveridad(severidadDiagnostico,descripcionDiagnostico);

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

    @GetMapping("/por-severidad")
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA')")
    public List<DiagnosticoContarPorSeveridadDTO> DiagnosticoContarPorSeveridadDTO() {
        List<Object[]> lista = dS.contarPorServeridad();
        List<DiagnosticoContarPorSeveridadDTO> listaDTO = new ArrayList<>();

        for (Object[] obj : lista) {
            DiagnosticoContarPorSeveridadDTO dto = new DiagnosticoContarPorSeveridadDTO();
            dto.setSeveridad((String) obj[0]);
            dto.setTotal(((Number) obj[1]).longValue());
            listaDTO.add(dto);
        }

        return listaDTO;
    }


}
