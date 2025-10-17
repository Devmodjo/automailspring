package com.victormodjo.automaticMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutomaticMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomaticMailApplication.class, args);
	}

}
