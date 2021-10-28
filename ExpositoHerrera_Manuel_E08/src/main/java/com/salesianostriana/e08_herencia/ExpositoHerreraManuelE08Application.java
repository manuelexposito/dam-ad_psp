package com.salesianostriana.e08_herencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExpositoHerreraManuelE08Application {

	public static void main(String[] args) {
		SpringApplication.run(ExpositoHerreraManuelE08Application.class, args);
	}

}
