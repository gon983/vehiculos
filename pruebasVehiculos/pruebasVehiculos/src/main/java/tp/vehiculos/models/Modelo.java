package tp.vehiculos.models;

import jakarta.persistence.*;
import tp.vehiculos.clases.MarcaDto;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_marca")
    private MarcaDto marca;
}
