package rentify.demo_api_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "estado_rsv")
public class StateRsv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estadoID")
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
}
