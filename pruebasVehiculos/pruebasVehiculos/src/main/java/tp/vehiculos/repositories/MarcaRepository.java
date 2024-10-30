package tp.vehiculos.repositories;

import org.springframework.data.repository.CrudRepository;
import tp.vehiculos.models.Marca;
import tp.vehiculos.models.Vehiculo;

public interface MarcaRepository extends CrudRepository<Marca,Integer> {

}
