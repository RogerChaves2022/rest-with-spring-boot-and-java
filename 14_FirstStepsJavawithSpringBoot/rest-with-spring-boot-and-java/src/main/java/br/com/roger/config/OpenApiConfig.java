package br.com.roger.config;

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
						.title("RESTful API with JAVA 18 SPRING BOOT3")
						.version("v1")
						.description("Api para testes e desenvolvimento")
						.termsOfService("http://pub.roger.com.br/minha-api")
						.license(
								new License().
								name("Apache 2.0")
								.url("http://pub.roger.com.br/minha-api")));
	}
	

}
