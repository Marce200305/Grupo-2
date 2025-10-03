package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.*;
import pe.edu.upc.trabajogrupo2.entities.Citas;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.ICitasService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private ICitasService cS;

    @GetMapping
    public List<CitaDTOList> listarCitas() {
        return cS.List().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,CitaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> insertarCita(@RequestBody CitaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Citas c = m.map(dto,Citas.class);
        cS.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cita "+c.getMotivoCita()
                +" creada");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA')")
    public ResponseEntity<?> listarCitaPorId(@PathVariable("id") Integer id) {
        Citas c = cS.ListId(id);
        if (c == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        CitaDTOList dto = m.map(c,CitaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> eliminarCita(@PathVariable("id") Integer id) {
        Citas c = cS.ListId(id);
        if (c == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        cS.delete(id);
        return ResponseEntity.ok("Cita "+id+" eliminada");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TERAPEUTA','PACIENTE')")
    public ResponseEntity<String> modificarCita(@RequestBody CitaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Citas c = m.map(dto,Citas.class);
        Citas ex = cS.ListId(c.getIdCita());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + c.getIdCita());
        }
        cS.update(c);
        return ResponseEntity.ok("Cita "+c.getMotivoCita()+" modificada");
    }
    @GetMapping("/busquedafecha")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?>buscar(@RequestParam LocalDate fechaCita){
        List<Citas> citas = cS.buscarcita(fechaCita);

        if(citas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("No se encontraron reservas con la fecha de buscada:"+fechaCita);
        }
        List<UsuarioDTOList> listaDTO = citas.stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTOList.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
    @GetMapping("/cantidadcitas")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> obtenerCantidad(@RequestParam String estadoCta) {
        Double cantidad=cS.contarporestado(estadoCta);

        if (cantidad==0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron dispositivos registrados " );
        }

        CitaDTOList dto = new CitaDTOList();
        dto.setEstadoCita(estadoCta);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/por-mes")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<CitasPorMesDTO> citasPorMes() {
        List<Object[]> lista = cS.CitasPorMes();
        List<CitasPorMesDTO> listaDTO = new ArrayList<>();

        for (Object[] obj : lista) {
            CitasPorMesDTO dto = new CitasPorMesDTO();
            dto.setMes(obj[0].toString().substring(0,7));
            dto.setTotal(((Number) obj[1]).longValue());
            listaDTO.add(dto);
        }

        return listaDTO;
    }


    @GetMapping("/por-usuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<CitaPorUsuarioDTO> citasPorUsuario() {
        List<Object[]> lista = cS.CitasPorUsuario();
        List<CitaPorUsuarioDTO> listaDTO = new ArrayList<>();

        for (Object[] obj : lista) {
            CitaPorUsuarioDTO dto = new CitaPorUsuarioDTO();
            dto.setId((Integer) obj[0]);
            dto.setTotalCitas(((Number) obj[1]).longValue());
            listaDTO.add(dto);
        }

        return listaDTO;
    }


    @GetMapping("/pendientes")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<CitaPendienteDTO> listarCitasPendientes() {
        List<Object[]> lista = cS.CitasPendientes();
        List<CitaPendienteDTO> listaDTO = new ArrayList<>();

        for (Object[] obj : lista) {
            CitaPendienteDTO dto = new CitaPendienteDTO();
            dto.setIdCita((Integer) obj[0]);
            dto.setEstado((String) obj[1]);
            dto.setFecha(((java.sql.Timestamp) obj[2]).toLocalDateTime());
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/reporte-estado-citas-pendientes")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> SeguimientoCitasPendientes(){
        List<EstadoCitasPendientesDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = cS.estadoCitasPendientes();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        for(String[] s:fila){
            EstadoCitasPendientesDTO dto = new EstadoCitasPendientesDTO();
            dto.setIdCita(Integer.parseInt(s[0]));
            dto.setNameUsuario(s[1]);
            dto.setApellidoUsuario(s[2]);
            dto.setEstadoCita(s[3]);
            dto.setFechaCita(LocalDateTime.parse(s[4], formatter));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }

}
