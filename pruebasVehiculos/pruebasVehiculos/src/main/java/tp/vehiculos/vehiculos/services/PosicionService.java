package tp.vehiculos.vehiculos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tp.vehiculos.vehiculos.configurations.Geolocalizacion;
import tp.vehiculos.vehiculos.dtos.PosicionDto;
import tp.vehiculos.vehiculos.configurations.ConfiguracionAgencia;
import tp.vehiculos.vehiculos.models.Posicion;
import tp.vehiculos.vehiculos.models.Vehiculo;
import tp.vehiculos.vehiculos.repositories.PosicionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PosicionService {
    private final VehiculoService serviceVehiculos;
    private final ConfiguracionService serviceConfiguracion;
    private final PosicionRepository repository;
    private static final String API_URL = "http://localhost:8001/personas/notificarVehiculo/";
    private final RestTemplate restTemplate;

    @Autowired
    public PosicionService(VehiculoService serviceVehiculos, ConfiguracionService serviceConfiguracion, PosicionRepository repository, RestTemplate restTemplate) {
        this.serviceVehiculos = serviceVehiculos;
        this.serviceConfiguracion = serviceConfiguracion;
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public void procesarPosicion(PosicionDto posicionDto){
        Optional<Vehiculo> vehiculo = serviceVehiculos.getVehiculoById(posicionDto.getIdVehiculo());
        // y si esta en Prueba
        if (vehiculo.isPresent()) {
            Posicion posicion = new Posicion(vehiculo.get(), posicionDto.getLatitud(), posicionDto.getLongitud());
            ConfiguracionAgencia agencia = serviceConfiguracion.obtenerConfiguration();
            boolean necesarioNotificar = agencia.asegurarCumplimientoNormas(posicion);
            guardarPosicion(posicion);
            if (necesarioNotificar){
                //ResponseEntity<Void> response = restTemplate.postForEntity(API_URL, posicion.toDto(), Void.class);


            }else{
                //System.out.println("No enviar notificacion");
            }



        } else {
            System.out.println("Vehículo no encontrado con ID: " + posicionDto.getIdVehiculo());
        }
    }

    public double calcularCantidadKm(LocalDateTime fechaInicio, LocalDateTime fechaFin, int idVehiculo){
        List<Posicion> posiciones = obtenerEntreFechas(fechaInicio,fechaFin)
                .stream()
                .filter(posicion -> {
                    return posicion.getVehiculo().getId() == idVehiculo;
                }).toList();

        Posicion posicion1 = null;
        double distanciaTotal = 0;
        double distancia = 0;
        for (Posicion posicion : posiciones) {
            if (posicion1 != null) {
                distancia = Geolocalizacion.calcularDistanciaEuclidiana(posicion.getLatitud(), posicion.getLongitud(), posicion1.getLatitud(), posicion1.getLongitud());
            }
            distanciaTotal += distancia;
            posicion1 = posicion;
        }

        return distanciaTotal;
    }

    public List<Posicion> obtenerEntreFechas(LocalDateTime fechaInicio,LocalDateTime fechaFin){
        return repository.findByFechaBetween(fechaInicio, fechaFin);

    }

    public void guardarPosicion(Posicion posicion){
        repository.save(posicion);

    }


}



