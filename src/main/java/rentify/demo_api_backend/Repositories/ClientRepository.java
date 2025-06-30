package rentify.demo_api_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rentify.demo_api_backend.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar clientes por identificación o contacto
    // Optional<Client> findByIdentification(String identification);
    // Optional<Client> findByContact(String contact);

}
