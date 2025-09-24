package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.*;
import pe.edu.upc.trabajogrupo2.entities.Roles;
import pe.edu.upc.trabajogrupo2.entities.Usuarios;
import pe.edu.upc.trabajogrupo2.entities.Videoconferencias;
import pe.edu.upc.trabajogrupo2.repositories.IUsuarioRepository;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private IUsuarioService ds;
    @GetMapping("/usuario")
    public List<UsuarioDTOList> Listarusuario(){
        return ds.List().stream().map(y->{
            ModelMapper m= new ModelMapper();
            return m.map(y, UsuarioDTOList.class);
        }).collect(Collectors.toList());

    }
    @GetMapping("/terapeuta")
    public List<UsuarioTerapeutaDTOList> Listarterapeuta(){
        return ds.List().stream().map(y->{
            ModelMapper m= new ModelMapper();
            return m.map(y, UsuarioTerapeutaDTOList.class);
        }).collect(Collectors.toList());

    }

    @PostMapping("/usuario")
    public ResponseEntity<String> insertarusuario(@RequestBody UsuarioDTOInsert dto)
    {
        ModelMapper m = new ModelMapper();
        Usuarios d=m.map(dto,Usuarios.class);
        ds.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario creado exitosamente: " + d.getNameUsuario());
    }
    @PostMapping("/terapeuta")
    public ResponseEntity<String> insertarterapeuta(@RequestBody UsuarioTerapeutaDTOInsert dto)
    {
        ModelMapper m = new ModelMapper();
        Usuarios d=m.map(dto,Usuarios.class);
        ds.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario creado exitosamente: " + d.getNameUsuario());
    }

    @GetMapping ("/{id}")

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
}
