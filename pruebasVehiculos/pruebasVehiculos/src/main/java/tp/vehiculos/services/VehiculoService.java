package tp.vehiculos.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.vehiculos.models.Vehiculo;
import tp.vehiculos.repositories.VehiculoRepository;

import java.util.List;


@Service
public class VehiculoService {
    private final VehiculoRepository repository;

    @Autowired
    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }
    public List<Vehiculo> obtenerTodos() {
        return repository.findAll();
    }
}
