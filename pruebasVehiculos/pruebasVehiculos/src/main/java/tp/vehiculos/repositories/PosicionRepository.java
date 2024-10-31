package tp.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tp.vehiculos.models.Posicion;
import tp.vehiculos.models.Vehiculo;

public interface PosicionRepository extends JpaRepository<Posicion,Integer> {
}
