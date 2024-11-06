package tp.vehiculos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posiciones")
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Vehiculo vehiculo;
    private LocalDateTime fecha_hora;
    private double latitud;
    private double longitud;
    //@Column(name="en_zona_restringida")
    private boolean enZonaRestringida;
    //@Column(name="fuera_de_radio_permitido")
    private boolean fueraDeRadioPermitido;

    public Posicion(Vehiculo vehiculo, double latitud, double longitud) {
        this.vehiculo = vehiculo;
        this.latitud= latitud;
        this.longitud = longitud;
        this.fecha_hora = LocalDateTime.now();
        this.enZonaRestringida = false;
        this.fueraDeRadioPermitido = false;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void enZonaRestringida() {
        this.enZonaRestringida = true;
    }

    public void fueraDeRadio(){
        this.fueraDeRadioPermitido = true;
    }
}
