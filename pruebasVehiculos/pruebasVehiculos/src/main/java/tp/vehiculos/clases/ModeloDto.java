package tp.vehiculos.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDto {
    private int id;
    private String descripcion;
    private MarcaDto marca;
}
