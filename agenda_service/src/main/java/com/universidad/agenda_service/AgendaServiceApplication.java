package com.universidad.agenda_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.universidad.agenda_service.Repositories")
@EntityScan(basePackages = "com.universidad.agenda_service.Entities")
public class AgendaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaServiceApplication.class, args);
	}

}
