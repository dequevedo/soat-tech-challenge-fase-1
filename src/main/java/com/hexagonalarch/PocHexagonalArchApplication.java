package com.hexagonalarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.hexagonalarch.adapters.driven")
public class PocHexagonalArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocHexagonalArchApplication.class, args);
	}

}
