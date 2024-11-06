package tp.vehiculos.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.vehiculos.models.Modelo;
import tp.vehiculos.models.Posicion;

import java.util.Set;


@Data
@NoArgsConstructor
public class VehiculoDto {
    private int id;
    private String patente;

    public VehiculoDto(int id, String patente) {
        this.id = id;
        this.patente = patente;
    }

    // private Set<PruebaDto> pruebas;
    //private ModeloDto modelo;
    //private Set<PosicionDto> posiciones;

    /*public VehiculoDto(int id, String patente){
        this.id = id;
        this.patente = patente;
    }*/
}
