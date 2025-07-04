package rentify.demo_api_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "acompanantes")
public class Accompanists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acompanantesID")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

}
