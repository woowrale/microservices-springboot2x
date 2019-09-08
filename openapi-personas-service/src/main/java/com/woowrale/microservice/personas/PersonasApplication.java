package com.woowrale.microservice.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The Class PersonasApplication.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PersonasApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PersonasApplication.class, args);
	}
}
