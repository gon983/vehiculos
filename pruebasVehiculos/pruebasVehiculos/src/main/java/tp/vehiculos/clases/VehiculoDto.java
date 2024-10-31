package tp.vehiculos.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
    private int id_modelo;
    private String patente;
    // private Set<PruebaDto> pruebas;
    private ModeloDto modelo;
    private Set<PosicionDto> posiciones;
}
