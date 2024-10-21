package com.hexagonalarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.hexagonalarch.adapters.outbound.mapper")
@EnableJpaRepositories(basePackages = "com.hexagonalarch.adapters.outbound")
public class PocHexagonalArchApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocHexagonalArchApplication.class, args);
    }

}
