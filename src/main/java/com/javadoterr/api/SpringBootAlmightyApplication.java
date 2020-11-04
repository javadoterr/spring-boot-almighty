package com.javadoterr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableScheduling
//@EnableBatchProcessing
@EnableJpaRepositories(basePackages = "com.javadoterr.api")
public class SpringBootAlmightyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAlmightyApplication.class, args);
	}

}
 