package rentify.demo_api_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sistemas")
public class Systems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sistemaID")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

}
