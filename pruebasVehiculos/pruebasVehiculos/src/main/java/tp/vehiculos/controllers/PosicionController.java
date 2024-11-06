package tp.vehiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.vehiculos.clases.PosicionDto;
import tp.vehiculos.configurations.ConfiguracionAgencia;
import tp.vehiculos.models.Posicion;
import tp.vehiculos.models.Vehiculo;
import tp.vehiculos.services.ConfiguracionService;
import tp.vehiculos.services.PosicionService;
import tp.vehiculos.services.VehiculoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/posicion")
public class PosicionController {
    private final PosicionService servicePosicion;

    @Autowired
    public PosicionController(PosicionService servicePosicion) {
        this.servicePosicion = servicePosicion;
    }

    @PostMapping("/posicion")
    public void recibirPosicion(@RequestBody PosicionDto posicionDto) {
        servicePosicion.procesarPosicion(posicionDto);

    }






}
