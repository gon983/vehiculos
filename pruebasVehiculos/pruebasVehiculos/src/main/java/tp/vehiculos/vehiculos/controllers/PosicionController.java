package tp.vehiculos.vehiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.vehiculos.vehiculos.dtos.PosicionDto;
import tp.vehiculos.vehiculos.services.PosicionService;

@RestController
@RequestMapping("/api/posicion")
public class PosicionController {
    private final PosicionService servicePosicion;

    @Autowired
    public PosicionController(PosicionService servicePosicion) {
        this.servicePosicion = servicePosicion;
    }

    @PostMapping("/")
    public void recibirPosicion(@RequestBody PosicionDto posicionDto) {
        servicePosicion.procesarPosicion(posicionDto);

    }






}
