package tp.vehiculos.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.vehiculos.vehiculos.models.Posicion;

import java.time.LocalDateTime;
import java.util.List;

public interface PosicionRepository extends JpaRepository<Posicion,Integer> {


    List<Posicion> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
