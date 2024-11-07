package tp.vehiculos.vehiculos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicionDto {
    //private int id;
    private int idVehiculo;
    // private LocalDateTime fecha_hora;
    private double latitud;
    private double longitud;

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
