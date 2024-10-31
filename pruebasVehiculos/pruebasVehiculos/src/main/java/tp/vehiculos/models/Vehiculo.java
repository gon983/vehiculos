package tp.vehiculos.models;

import jakarta.persistence.*;
import tp.vehiculos.clases.ModeloDto;
import tp.vehiculos.clases.PosicionDto;

import java.util.Set;


@Entity
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
}
