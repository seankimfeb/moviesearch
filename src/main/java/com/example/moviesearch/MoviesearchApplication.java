package com.example.moviesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.moviesearch.clients.MovieApiClient;
@SpringBootApplication
public class MoviesearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesearchApplication.class, args);
		
	}

}
