package rentify.demo_api_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "disponibilidad_auto")
public class AvailabilityCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispoID")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
}
