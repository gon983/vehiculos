package tp.vehiculos.repositories;

import org.springframework.data.repository.CrudRepository;
import tp.vehiculos.models.Posicion;
import tp.vehiculos.models.Vehiculo;

public interface PosicionRepository extends CrudRepository<Posicion,Integer> {
}
