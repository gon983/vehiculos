package tp.vehiculos.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicionDto {
    private int id;
    private LocalDateTime fecha_hora;
    private int latitud;
    private int longitud;

}
