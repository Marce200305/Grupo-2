package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.*;
import pe.edu.upc.trabajogrupo2.entities.Roles;
import pe.edu.upc.trabajogrupo2.entities.Usuarios;
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
}
