package tp.vehiculos.repositories;

import org.springframework.data.repository.CrudRepository;
import tp.vehiculos.models.Vehiculo;

public interface VehiculoRepository extends CrudRepository<Vehiculo,Integer> {
}
