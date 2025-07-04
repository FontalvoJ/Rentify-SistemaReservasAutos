package rentify.demo_api_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rentify.demo_api_backend.Model.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByNombreIgnoreCase(String nombre);

}
