package com.banregio.curso.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class CursoBackendBanregioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoBackendBanregioApplication.class, args);
	}
	// Integración de Swagger para pruebas REST
	@Bean
	public Docket productAPI() 
	{
		return new Docket( DocumentationType.SWAGGER_2 ).select()
				.apis( RequestHandlerSelectors.basePackage("com.banregio.curso.backend") ).build();
	}

}
