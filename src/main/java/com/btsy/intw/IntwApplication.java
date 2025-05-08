package com.btsy.intw;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bet API", version = "1.0", description = "API for managing bets and jackpots"))
public class IntwApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntwApplication.class, args);
	}

}
