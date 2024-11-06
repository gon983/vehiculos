package tp.vehiculos.vehiculos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.vehiculos.vehiculos.dtos.PosicionDto;
import tp.vehiculos.vehiculos.configurations.ConfiguracionAgencia;
import tp.vehiculos.vehiculos.models.Posicion;
import tp.vehiculos.vehiculos.models.Vehiculo;
import tp.vehiculos.vehiculos.repositories.PosicionRepository;

import java.util.Optional;

@Service
public class PosicionService {
    private final VehiculoService serviceVehiculos;
    private final ConfiguracionService serviceConfiguracion;
    private final PosicionRepository repository;

    @Autowired
    public PosicionService(VehiculoService serviceVehiculos, ConfiguracionService serviceConfiguracion, PosicionRepository repository) {
        this.serviceVehiculos = serviceVehiculos;
        this.serviceConfiguracion = serviceConfiguracion;
        this.repository = repository;
    }

    public void procesarPosicion(PosicionDto posicionDto){
        Optional<Vehiculo> vehiculo = serviceVehiculos.getVehiculoById(posicionDto.getIdVehiculo());

        if (vehiculo.isPresent()) {
            Posicion posicion = new Posicion(vehiculo.get(), posicionDto.getLatitud(), posicionDto.getLongitud());
            ConfiguracionAgencia agencia = serviceConfiguracion.obtenerConfiguration();
            boolean necesarioNotificar = agencia.asegurarCumplimientoNormas(posicion);
            guardarPosicion(posicion);
            if (necesarioNotificar){
                System.out.println("Enviar notificacion");
            }else{
                System.out.println("No enviar notificacion");
            }



        } else {
            System.out.println("Vehículo no encontrado con ID: " + posicionDto.getIdVehiculo());
        }
    }

    public void guardarPosicion(Posicion posicion){
        repository.save(posicion);

    }


}



