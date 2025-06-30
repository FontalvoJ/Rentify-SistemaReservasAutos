package rentify.demo_api_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "rolID")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre; // Ejemplo: "Administrador", "Cliente"

}
