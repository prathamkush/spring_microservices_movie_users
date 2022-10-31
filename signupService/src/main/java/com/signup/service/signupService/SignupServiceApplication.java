package com.signup.service.signupService;

import com.signup.service.signupService.model.User;
import com.signup.service.signupService.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

@SpringBootApplication
public class SignupServiceApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(SignupServiceApplication.class, args);
	}

	private final UserRepository userRepository;


	public SignupServiceApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//AtomicInteger i = new AtomicInteger(1);
		Stream.of("Alice", "Bob","Carol").forEach((user) -> userRepository.save(new User(user)));
		userRepository.findAll().forEach(System.out::println);
	}
}
