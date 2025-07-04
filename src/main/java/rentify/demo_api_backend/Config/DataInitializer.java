package rentify.demo_api_backend.Config;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import rentify.demo_api_backend.Model.*;
import rentify.demo_api_backend.Repositories.*;

import java.util.List;

@Configuration
public class DataInitializer {

        @Bean
        public CommandLineRunner initData(
                        RoleRepository roleRepository,
                        SystemsRepository systemsRepository,
                        AccompanistsRepository accompanistsRepository,
                        AvailabilityCarRepository availabilityCarRepository,
                        StateRsvRpository StateRsvRpository) {
                return args -> {
                        initIfEmpty(roleRepository, List.of(
                                        new Role(null, "Administrador"),
                                        new Role(null, "Cliente")), "Roles initialized.");

                        initIfEmpty(systemsRepository, List.of(
                                        new Systems(null, "Gasolina"),
                                        new Systems(null, "Híbrido"),
                                        new Systems(null, "Eléctrico"),
                                        new Systems(null, "Diesel")), "Systems initialized.");

                        initIfEmpty(accompanistsRepository, List.of(
                                        new Accompanists(null, "2"),
                                        new Accompanists(null, "4"),
                                        new Accompanists(null, "5"),
                                        new Accompanists(null, "7")), "Accompanists initialized.");

                        initIfEmpty(StateRsvRpository, List.of(
                                        new StateRsv(null, "Pendiente"),
                                        new StateRsv(null, "Activa"),
                                        new StateRsv(null, "Completada"),
                                        new StateRsv(null, "Cancelada")), "Reservation states initialized.");

                        initIfEmpty(availabilityCarRepository, List.of(
                                        new AvailabilityCar(null, "Disponible"),
                                        new AvailabilityCar(null, "No Disponible")),
                                        "Availability states initialized.");
                };
        }

        @Transactional
        private <T> void initIfEmpty(JpaRepository<T, ?> repository, List<T> items, String message) {
                if (repository.count() == 0) {
                        repository.saveAll(items);
                        System.out.println(message);
                }
        }
}
