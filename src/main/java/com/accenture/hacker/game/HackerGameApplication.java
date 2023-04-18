package com.accenture.hacker.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.accenture.hacker.game.config.DynamoDBConfig;
import com.accenture.hacker.game.entity.CredentialsRepository;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = CredentialsRepository.class))
@Import({DynamoDBConfig.class})
public class HackerGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackerGameApplication.class, args);
	}

}
