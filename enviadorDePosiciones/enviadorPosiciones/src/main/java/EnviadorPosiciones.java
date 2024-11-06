import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class EnviadorPosiciones {

    private static final String URL_API = "http://localhost:8084/api/posicion/";

    public static void main(String[] args) {
        EnviadorPosiciones enviador = new EnviadorPosiciones();
        enviador.enviarPosiciones();
    }

    public void enviarPosiciones() {
        // Array 1: Movimiento dentro del radio permitido y evitando zonas restringidas
        List<String> posicionesDentroDeRadio = List.of(
                "{\"idVehiculo\":1,\"latitud\":42508900,\"longitud\":153472000}",
                "{\"idVehiculo\":1,\"latitud\":42509000,\"longitud\":153473000}",
                "{\"idVehiculo\":1,\"latitud\":42509100,\"longitud\":153474000}",
                "{\"idVehiculo\":1,\"latitud\":42509200,\"longitud\":153475000}",
                "{\"idVehiculo\":1,\"latitud\":42509300,\"longitud\":153476000}"
        );

        // Array 2: Comienza dentro del radio, pero sale progresivamente
        List<String> posicionesSalidaDeRadio = List.of(
                "{\"idVehiculo\":2,\"latitud\":42508900,\"longitud\":153472000}",
                "{\"idVehiculo\":2,\"latitud\":42509400,\"longitud\":153480000}",
                "{\"idVehiculo\":2,\"latitud\":42509800,\"longitud\":153490000}",
                "{\"idVehiculo\":2,\"latitud\":42510000,\"longitud\":153500000}",
                "{\"idVehiculo\":2,\"latitud\":42510500,\"longitud\":153510000}"
        );

        // Enviar posiciones dentro del radio
        posicionesDentroDeRadio.forEach(this::enviarPosicionJson);

        // Enviar posiciones que salen del radio
        posicionesSalidaDeRadio.forEach(this::enviarPosicionJson);
    }

    private void enviarPosicionJson(String posicionJson) {
        RestTemplate restTemplate = new RestTemplate();

        // Configurar encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la solicitud con el JSON como contenido
        HttpEntity<String> request = new HttpEntity<>(posicionJson, headers);

        // Enviar la solicitud
        ResponseEntity<Void> response = restTemplate.postForEntity(URL_API, request, Void.class);
    }
}




