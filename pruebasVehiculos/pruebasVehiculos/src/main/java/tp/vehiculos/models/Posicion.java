package tp.vehiculos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime fecha_hora;
    private int latitud;
    private int longitud;
}
