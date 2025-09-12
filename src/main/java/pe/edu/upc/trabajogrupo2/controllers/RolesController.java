package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<RolesDTO>Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m= new ModelMapper();
            return m.map(y,RolesDTO.class);
        }).collect(Collectors.toList());
    }
}
