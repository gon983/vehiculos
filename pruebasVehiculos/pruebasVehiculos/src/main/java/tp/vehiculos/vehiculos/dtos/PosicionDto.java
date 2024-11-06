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
    private int latitud;
    private int longitud;

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public int getLatitud() {
        return latitud;
    }

    public int getLongitud() {
        return longitud;
    }
}
