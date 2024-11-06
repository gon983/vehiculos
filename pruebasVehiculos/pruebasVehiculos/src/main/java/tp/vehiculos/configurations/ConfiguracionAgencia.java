package tp.vehiculos.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tp.vehiculos.models.Posicion;

import java.util.List;

public class ConfiguracionAgencia {
    @JsonProperty("coordenadasAgencia")
    private Coordenadas coordenadasAgencia;
    @JsonProperty("radioAdmitidoKm")
    private double radioAdmitidoKm;
    @JsonProperty("zonasRestringidas")
    private List<ZonaRestringida> zonasRestringidas;

    public void asegurarCumplimientoNormas(Posicion posicion){
        if (fueraDeRadio(posicion) || enZonaRestringida(posicion)){
            System.out.println("Se deberia mandar una notificacion");
        } else {
            System.out.println("No se deberia mandar una notificacion");
        }

    }

    public boolean fueraDeRadio(Posicion posicion){
        double distancia = calcularDistanciaEuclidiana(coordenadasAgencia.getLatitud(), coordenadasAgencia.getLongitud(), posicion.getLatitud(), posicion.getLongitud());
        if(distancia>radioAdmitidoKm){
            posicion.fueraDeRadio();
            return true;
        }
        return false;

    }

    public boolean enZonaRestringida(Posicion posicion) {
        double lat = posicion.getLatitud();
        double lon = posicion.getLongitud();


        for (ZonaRestringida zona : zonasRestringidas) {
            if (zona.estaEnZonaRestringida(lat, lon)) {
                posicion.enZonaRestringida();
                return true;
            }
        }
        return false;
    }

    public static double calcularDistanciaEuclidiana(double lat1, double lon1, double lat2, double lon2) {
        double CONVERSION_GRADOS_A_KM = 111.0;
        double lat1Km = lat1 * CONVERSION_GRADOS_A_KM;
        double lon1Km = lon1 * CONVERSION_GRADOS_A_KM;
        double lat2Km = lat2 * CONVERSION_GRADOS_A_KM;
        double lon2Km = lon2 * CONVERSION_GRADOS_A_KM;

        // Usar el teorema de Pitágoras para calcular la distancia euclidiana
        double distancia = Math.sqrt(Math.pow(lat2Km - lat1Km, 2) + Math.pow(lon2Km - lon1Km, 2));

        return distancia;
    }

    @Data
    public static class Coordenadas {
        @JsonProperty("lat")
        private double lat;
        @JsonProperty("lon")
        private double lon;

        public double getLatitud() {
            return lat;
        }

        public double getLongitud() {
            return lon;
        }

        @Override
        public String toString() {
            return "Coordenadas{" +
                    "lat=" + lat +
                    ", lon=" + lon +
                    '}';
        }
    }

    @Data
    public static class ZonaRestringida {
        @JsonProperty("noroeste")
        private Coordenadas noroeste;
        @JsonProperty("sureste")
        private Coordenadas sureste;



        public boolean estaEnZonaRestringida(double latitud, double longitud){
            return latitud <= noroeste.getLatitud() && latitud >= sureste.getLatitud()
                    && longitud >= noroeste.getLongitud() && longitud <= sureste.getLongitud();



        }

        @Override
        public String toString() {
            return "ZonaRestringida{" +
                    "noroeste=" + noroeste +
                    ", sureste=" + sureste +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ConfiguracionAgencia{" +
                "coordenadasAgencia=" + coordenadasAgencia +
                ", radioAdmitidoKm=" + radioAdmitidoKm +
                ", zonasRestringidas=" + zonasRestringidas +
                '}';
    }
}

