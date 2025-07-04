package rentify.demo_api_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rentify.demo_api_backend.Model.Accompanists;
import java.util.Optional;

public interface AccompanistsRepository extends JpaRepository<Accompanists, Long> {
    Optional<Accompanists> findByNombreIgnoreCase(String nombre);

}
