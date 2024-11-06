package tp.vehiculos.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.vehiculos.vehiculos.models.Posicion;

public interface PosicionRepository extends JpaRepository<Posicion,Integer> {
}
