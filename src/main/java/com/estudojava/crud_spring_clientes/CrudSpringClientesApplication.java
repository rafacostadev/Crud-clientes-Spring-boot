package com.estudojava.crud_spring_clientes;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CrudSpringClientesApplication {

	@Configuration
	public class ModelMapperConfig {
		@Bean
		ModelMapper modelMapper() {
			return new ModelMapper();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringClientesApplication.class, args);
	}

}
