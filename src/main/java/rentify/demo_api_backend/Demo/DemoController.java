package rentify.demo_api_backend.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/information")
    public Map<String, String> getInformation() {
        return Map.of(
                "author", "FontalvoJ",
                "license", "ISC",
                "description",
                "RentifyAPI 🚗🔑 es una plataforma segura y eficiente para gestionar el alquiler de vehículos en tiempo real 📅. Diseñada tanto para administradores como para clientes, permite a los administradores autenticar usuarios, actualizar datos de clientes y vehículos, listar clientes, añadir autos para reservación y gestionar las reservaciones mediante su activación o eliminación 📊. Por otro lado, los clientes pueden registrarse y acceder de forma segura, realizar reservaciones, listar sus reservas activas, actualizar su información personal y eliminar su cuenta cuando lo deseen 🔄. Con una integración fluida y funcionalidades intuitivas, RentifyAPI garantiza una experiencia de alquiler cómoda y confiable para usuarios en cualquier parte del mundo 🌍.");
    }

    @PostMapping("/demo")
    public String Welcome() {
        return "Demo endpoint reached";
    }

}
