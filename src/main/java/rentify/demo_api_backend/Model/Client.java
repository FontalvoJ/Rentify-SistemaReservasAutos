package rentify.demo_api_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteID")
    private Long id;

    @Column(name = "identificacion", nullable = false, length = 20)
    private String identification;

    @Column(name = "contacto", nullable = false, length = 15)
    private String contact;

    @Column(name = "direccion", nullable = false, length = 200)
    private String address;

    @OneToOne
    @JoinColumn(name = "usuariosID", nullable = false)
    private User user;
}
