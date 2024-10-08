package com.yahia.AOP;

import com.yahia.AOP.dao.demoDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(demoDAO demo){
		return runner -> {
			demo.around();
		};
	}
}
