package dev.cedric.runnerz;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.classic.Logger;
import dev.cedric.runnerz.run.Location;
import dev.cedric.runnerz.run.Run;
@SpringBootApplication
public class Application {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "first run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.INDOOR);
			log.info("Run created: {}", run);
		};
	}
	
}
