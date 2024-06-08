package com.mohammad_bakur.Dealer_management_api;

import com.github.javafaker.Faker;
import com.mohammad_bakur.Dealer_management_api.repositories.DealerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

	@Bean
	CommandLineRunner runner(DealerRepository dealerRepo){
	return args->{

		Faker faker = new Faker();
		String fullName = faker.name().fullName();

		Dealer dealer = new Dealer(
				fullName,
				faker.internet().emailAddress(),
				faker.phoneNumber().toString(),
				faker.internet().password(),
				faker.address().toString(),
				LocalDateTime.now()

		);

		//dealerRepo.save(dealer);
		};
	}
}
