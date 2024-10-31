package tp.vehiculos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime fecha_hora;
    private int latitud;
    private int longitud;
}
