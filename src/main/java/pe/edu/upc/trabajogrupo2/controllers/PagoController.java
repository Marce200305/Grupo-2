package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.PagoDTOInsert;
import pe.edu.upc.trabajogrupo2.dtos.PagoDTOList;
import pe.edu.upc.trabajogrupo2.dtos.QueryPagosDTO;
import pe.edu.upc.trabajogrupo2.entities.Pagos;
import pe.edu.upc.trabajogrupo2.servicesinterfaces.IPagosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    private IPagosService pS;

    @GetMapping
    public List<PagoDTOList> listarPagos() {
        return pS.List().stream().map(p->{
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertarPago(@RequestBody PagoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Pagos p = m.map(dto,Pagos.class);
        pS.insert(p);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pago "+p.getFechaPago()
                +" creado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPagoPorId(@PathVariable("id") Integer id) {
        Pagos p = pS.ListId(id);
        if (p == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PagoDTOList dto = m.map(p, PagoDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPago(@PathVariable("id") Integer id) {
        Pagos p = pS.ListId(id);
        if (p == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + id);
        }
        pS.delete(id);
        return ResponseEntity.ok("Pago "+id+" eliminado");
    }

    @PutMapping
    public ResponseEntity<String> modificarPago(@RequestBody PagoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Pagos p = m.map(dto,Pagos.class);
        Pagos ex = pS.ListId(p.getIdPago());
        if (ex == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay registro con el ID: " + p.getIdPago());
        }
        pS.update(p);
        return ResponseEntity.ok("Pago "+p.getFechaPago()+" modificado");
    }
    @GetMapping("/montos")
    public ResponseEntity<?> montototal() {
        Double total = pS.Sumadepagos();

        if (total==0 ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay registros" );
        }
        QueryPagosDTO dto = new QueryPagosDTO();
        dto.setMontoPago(total.doubleValue());
        return ResponseEntity.ok(dto);
    }
}
