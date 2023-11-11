package br.com.alura.SeriesFinder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.SeriesFinder.principal.Principal;

@SpringBootApplication
public class SeriesFinderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeriesFinderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibeMenu();

	}

}
