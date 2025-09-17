package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.RolesDTO;
import java.util.List;
import java.util.stream.Collectors;

import pe.edu.upc.trabajogrupo2.entities.Roles;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IRolesService;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private IRolesService dS;

    @GetMapping
    public List<RolesDTO> listarRoles(){
        return dS.List().stream().map(y->{
            ModelMapper m= new ModelMapper();
            return m.map(y,RolesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody RolesDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Roles d=m.map(dto,Roles.class);
        dS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Rol creado exitosamente"+d.getNameRole());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Roles rol = dS.ListId(id);
        if (rol == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RolesDTO dto = m.map(rol, RolesDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Roles rol = dS.ListId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        dS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolesDTO dto) {
        ModelMapper m = new ModelMapper();
        Roles rol = m.map(dto, Roles.class);

        Roles existente = dS.ListId(rol.getIdRole());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + rol.getIdRole());
        }
        dS.update(rol);
        return ResponseEntity.ok("Registro con ID " + rol.getIdRole() + " modificado correctamente.");
    }
}
