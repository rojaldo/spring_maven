package com.example.demo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.beers.BeerEntity;
import com.example.demo.beers.BeersRepository;
import com.example.demo.beers.BeersService;
import com.example.demo.beers.BeerDto;

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
	@Bean
	public CommandLineRunner addBeers(BeersService beersService) {
		return (args) -> {
			BeerDto[] beers = beersService.getBeersFromApi();
			System.out.println("Number of beers in database: " + beers.length);
		};
	}


}
