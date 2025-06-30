package rentify.demo_api_backend.Services.Authentication;

import lombok.RequiredArgsConstructor;

import java.util.List;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rentify.demo_api_backend.Dtos.Auth.AuthResponse;
import rentify.demo_api_backend.Dtos.Auth.LoginRequest;
import rentify.demo_api_backend.Dtos.Auth.RegisterRequest;
import rentify.demo_api_backend.Jwt.JwtService;
import rentify.demo_api_backend.Model.Client;
import rentify.demo_api_backend.Model.Role;
import rentify.demo_api_backend.Model.User;
import rentify.demo_api_backend.Repositories.ClientRepository;
import rentify.demo_api_backend.Repositories.RoleRepository;
import rentify.demo_api_backend.Repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final ClientRepository clientRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {

                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                User user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new RuntimeException(
                                                "Usuario no encontrado: " + request.getEmail()));

                String token = jwtService.getToken(user);

                return AuthResponse.builder()
                                .token(token)
                                .nombre(user.getName())
                                .role(user.getRole().getNombre())
                                .build();
        }

        public AuthResponse register(RegisterRequest request) {

                List<String> rolesValidos = List.of("Administrador", "Cliente");

                if (!rolesValidos.contains(request.getRole())) {
                        throw new RuntimeException("Rol inválido: " + request.getRole());
                }

                Role role = roleRepository.findByNombreIgnoreCase(request.getRole())
                                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + request.getRole()));

                User user = User.builder()
                                .name(request.getNombre())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(role)
                                .build();

                userRepository.save(user);

                if (request.getRole().equalsIgnoreCase("Cliente")) {
                        Client client = Client.builder()
                                        .identification(request.getIdentificacion())
                                        .contact(request.getContacto())
                                        .address(request.getDireccion())
                                        .user(user)
                                        .build();

                        clientRepository.save(client);
                }

                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .nombre(user.getName())
                                .role(user.getRole().getNombre())
                                .build();
        }
}
