package rentify.demo_api_backend.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import rentify.demo_api_backend.Model.Systems;
import java.util.Optional;

public interface SystemsRepository extends JpaRepository<Systems, Long> {
    Optional<Systems> findByNombreIgnoreCase(String nombre);
}
