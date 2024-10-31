package tp.vehiculos.controllers;


import com.example.entradasKempes.dtos.EntradaDto;
import com.example.entradasKempes.models.Entrada;
import com.example.entradasKempes.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tp.vehiculos.clases.VehiculoDto;
import tp.vehiculos.models.Vehiculo;
import tp.vehiculos.services.VehiculoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    private final VehiculoService service;

    @Autowired
    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDto>> obtenerVehiculos() {
        List<Vehiculo> vehiculos = service.obtenerTodos();
        List<VehiculoDto> vehiculosDto = vehiculos.stream().map(v->v.toDto()).collect(Collectors.toList());
        return ResponseEntity.ok(vehiculosDto);
    }


}