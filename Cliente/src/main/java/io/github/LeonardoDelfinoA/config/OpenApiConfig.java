package io.github.LeonardoDelfinoA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API de Clientes cadastrados")
						.version("v1")
						.description("Api feita para gerenciar dados de clientes cadastrados")
						.termsOfService("https://github.com/LeonardoDelfinoA")
						.license(
							new License()
								.name("Apache 2.0")
								.url("https://github.com/LeonardoDelfinoA")));
	}
}
