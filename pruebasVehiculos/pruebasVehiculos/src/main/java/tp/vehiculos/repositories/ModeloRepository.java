package tp.vehiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tp.vehiculos.models.Modelo;
import tp.vehiculos.models.Vehiculo;

public interface ModeloRepository extends JpaRepository<Modelo,Integer> {
}
