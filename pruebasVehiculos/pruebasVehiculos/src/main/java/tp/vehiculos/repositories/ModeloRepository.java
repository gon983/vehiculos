package tp.vehiculos.repositories;

import org.springframework.data.repository.CrudRepository;
import tp.vehiculos.models.Modelo;
import tp.vehiculos.models.Vehiculo;

public interface ModeloRepository extends CrudRepository<Modelo,Integer> {
}
