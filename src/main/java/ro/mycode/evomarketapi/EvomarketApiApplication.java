package ro.mycode.evomarketapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EvomarketApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvomarketApiApplication.class, args);

	}


	@Bean
	CommandLineRunner commandLineRunner(

	) {
		return args -> {
			System.out.println("Hello World");

		};
	}

}
