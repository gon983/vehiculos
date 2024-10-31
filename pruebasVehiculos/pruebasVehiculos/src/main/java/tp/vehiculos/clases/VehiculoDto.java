package tp.vehiculos.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.vehiculos.models.Modelo;
import tp.vehiculos.models.Posicion;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
    private int id;
    private String patente;
    // private Set<PruebaDto> pruebas;
    private ModeloDto modelo;
    private Set<PosicionDto> posiciones;


}
