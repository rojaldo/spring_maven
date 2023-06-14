package com.example.demo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.example.demo.beers.beers.BeerDto;
import com.example.demo.beers.beers.BeerEntity;
import com.example.demo.beers.beers.BeersRepository;
import com.example.demo.beers.beers.BeersService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// initialize rest template
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Get beers from API and save them to database
	// @Bean
	// @Profile("!test")
	// public CommandLineRunner addBeers(BeersService beersService) {
	// 	return (args) -> {
	// 		BeerDto[] beers = beersService.getBeersFromApi();
	// 		System.out.println("Number of beers in database: " + beers.length);
	// 	};
	// }


}
