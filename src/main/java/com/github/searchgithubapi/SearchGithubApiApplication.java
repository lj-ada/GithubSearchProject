package com.github.searchgithubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SearchGithubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchGithubApiApplication.class, args);
	}

}
