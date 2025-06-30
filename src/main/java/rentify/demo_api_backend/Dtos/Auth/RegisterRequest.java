package rentify.demo_api_backend.Dtos.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nombre;
    private String email;
    private String password;

    private String role;

    private String identificacion;
    private String contacto;
    private String direccion;

}
