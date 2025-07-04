package rentify.demo_api_backend.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import rentify.demo_api_backend.Model.AvailabilityCar;

public interface AvailabilityCarRepository extends JpaRepository<AvailabilityCar, Long> {

    Optional<AvailabilityCar> findByNombreIgnoreCase(String nombre);

}
