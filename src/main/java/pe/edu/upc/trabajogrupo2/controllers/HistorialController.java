package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.HistorialDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.HistorialDTOList;
import pe.edu.upc.trabajogrupo2.dtos.VideoconferenciaDTOList;
import pe.edu.upc.trabajogrupo2.entities.Historial;
import pe.edu.upc.trabajogrupo2.entities.Videoconferencias;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IHistorialService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historiales")
public class HistorialController {
    @Autowired
    private IHistorialService hS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('TERAPEUTA','PACIENTE')")
    public List<HistorialDTOList> listarHistoriales() {
        return hS.List().stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h, HistorialDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")
    public ResponseEntity<String> insertarHistorial(@RequestBody HistorialDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Historial h = m.map(dto,Historial.class);
        hS.insert(h);
        return ResponseEntity.status(HttpStatus.CREATED).body("Historial "+h.getDocumentacionHistorial()
                +" creado");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")
    public ResponseEntity<?> listarHistorialPorId(@PathVariable("id") Integer id) {
        Historial h = hS.ListId(id);
        if (h == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        HistorialDTOList dto = m.map(h, HistorialDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")

    public ResponseEntity<String> eliminarHistorial(@PathVariable("id") Integer id) {
        Historial h = hS.ListId(id);
        if (h == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        hS.delete(id);
        return ResponseEntity.ok("Historial "+id+" eliminado");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('TERAPEUTA')")

    public ResponseEntity<String> modificarHistorial(@RequestBody HistorialDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Historial h = m.map(dto,Historial.class);
        Historial ex = hS.ListId(h.getIdHistorial());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + h.getIdHistorial());
        }
        hS.update(h);
        return ResponseEntity.ok("Historial "+h.getDocumentacionHistorial()+" modificado");
    }
    @GetMapping("/queryhistorial")
    @PreAuthorize("hasAnyAuthority('PACIENTE')")
    public ResponseEntity<?>buscarhistorial(@RequestParam Integer idUsuario){
        List<String> historial = hS.findDocumentacionByUsuarioId(idUsuario);

        if(historial.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("No se encontraron reservas con la fecha de buscada:"+idUsuario);
        }
        List<HistorialDTOList> listaDTO = historial.stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,HistorialDTOList.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
