package previsaotempoapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;

@SpringBootApplication
public class PrevisaoTempoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PrevisaoTempoApiApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {}

}
