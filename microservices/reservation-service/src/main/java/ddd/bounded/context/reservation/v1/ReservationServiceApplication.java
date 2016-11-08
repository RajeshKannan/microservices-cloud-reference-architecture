package ddd.bounded.context.reservation.v1;

import ddd.bounded.context.reservation.v1.domain.Reservation;
import ddd.bounded.context.reservation.v1.endpoints.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ReservationServiceApplication {

	@Bean
    CommandLineRunner runner(ReservationRepository rr) {
		return args -> {

			rr.deleteAll();

            Stream.of("Diwali Party", "Halloween Party").forEach(name -> rr.save(new Reservation(name)));


			rr.findAll().forEach(System.out::println);
		};
	}

    @Bean
    HealthIndicator healthIndicator() {
        return () -> Health.status("I <3 Spring!").build();
    }
	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);



	}
}
