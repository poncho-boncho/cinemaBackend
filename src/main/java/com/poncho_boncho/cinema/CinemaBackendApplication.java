package com.poncho_boncho.cinema;

import com.poncho_boncho.cinema.api.model.User;
import com.poncho_boncho.cinema.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CinemaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBackendApplication.class, args);}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository user, PasswordEncoder encoder){
		return args -> {
			user.save(new User(1L,"user",encoder.encode("qwerty"),"ROLE_USER"));
			user.save(new User(2L,"admin",encoder.encode("admin"),"ROLE_ADMIN"));
		};
	}
}
