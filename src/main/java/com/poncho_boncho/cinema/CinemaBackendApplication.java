package com.poncho_boncho.cinema;

import com.poncho_boncho.cinema.client.StaffRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class CinemaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBackendApplication.class, args);}

	/*@Bean
	StaffRestClient staffRestClient(){
		RestClient client = RestClient.builder().baseUrl("http://localhost:8080").build();
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();
		return factory.createClient(StaffRestClient.class);
	}*/

}
