package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.DiagnosticoDTOList;
import pe.edu.upc.trabajogrupo2.dtos.VideoconferenciaDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.VideoconferenciaDTOList;
import pe.edu.upc.trabajogrupo2.entities.Diagnosticos;
import pe.edu.upc.trabajogrupo2.entities.Videoconferencias;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IVideoconferenciasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/videoconferencias")
public class VideoconferenciaController {
    @Autowired
    private IVideoconferenciasService vcS;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','TERAPEUTA','PACIENTE')")
    public List<VideoconferenciaDTOList> listarVideoconferencias() {
        return vcS.List().stream().map(vc->{
            ModelMapper m = new ModelMapper();
            return m.map(vc, VideoconferenciaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> insertarVideoconferencia(@RequestBody VideoconferenciaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Videoconferencias vc = m.map(dto, Videoconferencias.class);
        vcS.insert(vc);
        return ResponseEntity.status(HttpStatus.CREATED).body("Videoconferencia en "
                +vc.getProveedorVideoconferencia()+" creada");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> listarVideoconferenciaPorId(@PathVariable("id") Integer id) {
        Videoconferencias vc = vcS.ListId(id);
        if (vc == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        VideoconferenciaDTOList dto = m.map(vc, VideoconferenciaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> eliminarVideoconferencia(@PathVariable("id") Integer id) {
        Videoconferencias vc = vcS.ListId(id);
        if (vc == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + id);
        }
        vcS.delete(id);
        return ResponseEntity.ok("Videoconferencia "+id+" eliminada");
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> modificarVideoconferencia(@RequestBody VideoconferenciaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Videoconferencias vc = m.map(dto, Videoconferencias.class);
        Videoconferencias ex = vcS.ListId(vc.getIdVideoconferencia());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + vc.getIdVideoconferencia());
        }
        vcS.update(vc);
        return ResponseEntity.ok("Videoconferencia en "
                +vc.getProveedorVideoconferencia()+" modificada");
    }
    @GetMapping("/proveedor")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?>buscarproveedor(@RequestParam String proveedorVideoconferencia){
        List<Videoconferencias> videoconferencias = vcS.bucarporproveedor(proveedorVideoconferencia);

        if(videoconferencias.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("No se encontraron reservas con la fecha de buscada:"+proveedorVideoconferencia);
        }
        List<VideoconferenciaDTOList> listaDTO = videoconferencias.stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,VideoconferenciaDTOList.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
