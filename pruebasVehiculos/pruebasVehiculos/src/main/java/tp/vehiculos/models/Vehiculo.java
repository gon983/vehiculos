package tp.vehiculos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tp.vehiculos.clases.ModeloDto;
import tp.vehiculos.clases.PosicionDto;
import tp.vehiculos.clases.VehiculoDto;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patente;
    // private Set<PruebaDto> pruebas;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vehiculo")
    private Set<Posicion> posiciones;

    public VehiculoDto toDto(){
        return new VehiculoDto(id,patente);
    }

}


