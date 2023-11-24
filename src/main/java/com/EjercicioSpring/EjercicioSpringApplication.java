package com.EjercicioSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:C:/Users/jupac/OneDrive/Documentos/Secrets/config.properties")
public class EjercicioSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioSpringApplication.class, args);
	}


}
