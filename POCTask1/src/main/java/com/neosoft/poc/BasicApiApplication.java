package com.neosoft.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

public class BasicApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApiApplication.class, args);
	}

}
