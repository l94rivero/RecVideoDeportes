package com.ar.rec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.ar.servicios")
@ComponentScan("com.ar.repositorios")
public class RecApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecApplication.class, args);
	}

}
