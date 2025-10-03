package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.*;
import pe.edu.upc.trabajogrupo2.entities.Roles;
import pe.edu.upc.trabajogrupo2.entities.Usuarios;
import pe.edu.upc.trabajogrupo2.entities.Videoconferencias;
import pe.edu.upc.trabajogrupo2.repositories.IUsuarioRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IUsuarioService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private IUsuarioService ds;
    @GetMapping("/usuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UsuarioDTOList> Listarusuario(){
        final String ROL_PACIENTE = "PACIENTE";
        return ds.Listarporrol(ROL_PACIENTE).stream().map(y->{
            ModelMapper m= new ModelMapper();
            return m.map(y, UsuarioDTOList.class);
        }).collect(Collectors.toList());

    }
    @GetMapping("/terapeuta")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UsuarioTerapeutaDTOList> Listarterapeuta(){
        final String ROL_TERAPEUTA = "TERAPEUTA";
        return ds.Listarporrol(ROL_TERAPEUTA).stream().map(y->{
            ModelMapper m= new ModelMapper();
            return m.map(y, UsuarioTerapeutaDTOList.class);
        }).collect(Collectors.toList());

    }

    @PostMapping("/usuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> insertarusuario(@RequestBody UsuarioDTOInsert dto)
    {
        ModelMapper m = new ModelMapper();
        Usuarios d=m.map(dto,Usuarios.class);
        ds.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario creado exitosamente: " + d.getNameUsuario());
    }
    @PostMapping("/terapeuta")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> insertarterapeuta(@RequestBody UsuarioTerapeutaDTOInsert dto)
    {
        ModelMapper m = new ModelMapper();
        Usuarios d=m.map(dto,Usuarios.class);
        ds.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario creado exitosamente: " + d.getNameUsuario());
    }

    @GetMapping ("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> ListId(@PathVariable("id") Integer id) {
        Usuarios d= ds.ListId(id);

        if (d == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        VideoconferenciaDTOList dto = m.map(d, VideoconferenciaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> deletear(@PathVariable("id") Integer id) {
        Usuarios d = ds.ListId(id);
        if (d == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + id);
        }
        ds.delete(id);
        return ResponseEntity.ok("Usuario "+id+" eliminada");
    }

    @PutMapping("/usuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> updatear(@RequestBody UsuarioDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Usuarios d = m.map(dto, Usuarios.class);
        Usuarios f = ds.ListId(d.getIdUsuario());
        if (f == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + d.getIdUsuario());
        }
        ds.update(d);
        return ResponseEntity.ok("Usuario en "
                +d.getNameUsuario()+" modificada");
    }

    @PutMapping("/terapeuta")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> updatearterapeuta(@RequestBody UsuarioTerapeutaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Usuarios d = m.map(dto, Usuarios.class);
        Usuarios f = ds.ListId(d.getIdUsuario());
        if (f == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registros con el ID: " + d.getIdUsuario());
        }
        ds.update(d);
        return ResponseEntity.ok("Usuario en "
                +d.getNameUsuario()+" modificada");
    }

    @GetMapping("/mas-citas-agendadas")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> TotalCitasDesc(){
        List<TotalCitasUsuarioDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = ds.masCitasAgendadas();
        for(String[] s:fila){
            TotalCitasUsuarioDTO dto = new TotalCitasUsuarioDTO();
            dto.setNameUsuario(s[0]);
            dto.setApellidoUsuario(s[1]);
            dto.setCantidadCitas(Integer.parseInt(s[2]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/estado-progreso-usuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> ProgresoDeUsuario(){
        List<ReporteProgresoUsuarioDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = ds.ReporteProgresoPaciente();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        for(String[] s:fila){
            ReporteProgresoUsuarioDTO dto = new ReporteProgresoUsuarioDTO();
            dto.setNameUsuario(s[0]);
            dto.setApellidoUsuario(s[1]);
            dto.setFechaReporte(LocalDateTime.parse(s[2], formatter));
            dto.setDetalleReporte(s[3]);
            dto.setProgresoReporte(Integer.parseInt(s[4]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }
}