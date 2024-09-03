package br.com.israeloliveira.user_api;

import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new Patient(null, "Israel Oliveira", "israel@email.com", "1234","man", LocalDate.of(1998,9, 8), "02542000","111.111.111-11")
		));

	}
}
