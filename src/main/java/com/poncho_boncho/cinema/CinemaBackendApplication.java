package com.poncho_boncho.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CinemaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBackendApplication.class, args);
	}

/*	@GetMapping("/simple")
	public String simpleRequest(){
		return "ok";
	}*/
}
