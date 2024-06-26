package io.github.LeonardoDelfinoA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EntityScan({"io.github.LeonardoDelfinoA.model"})
public class ClienteApplication {

	/*@Bean
	public CommandLineRunner run( @Autowired ClienteRepository repository ) {
		return args -> {
			Cliente cliente = Cliente.builder().cpf("00000000000").nome("Fulano").build();
			repository.save(cliente);
		};
	}*/
	
	
	@Autowired
	@Qualifier("applicationName")
	private String applicationName;

	@GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}
}
