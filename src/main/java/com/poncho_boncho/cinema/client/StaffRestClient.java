package com.poncho_boncho.cinema.client;

import com.poncho_boncho.cinema.api.model.Staff;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.util.List;

@Component
public class StaffRestClient {

    private final RestClient restClient;


    public StaffRestClient(){
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    public List<Staff> findAll(){
        System.out.println("qwedwdad");
        return restClient.get()
                .uri("/staff")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Staff>>() {
                });
    }
    public Staff findById (Integer id){
        return restClient.get()
                .uri("/staff/{id}", id)
                .retrieve()
                .body(Staff.class);
    }

    public Staff create(Staff staff){
        System.out.println("vvvvvvvv");
        return restClient.post()
                .uri("/staff")
                .contentType(MediaType.APPLICATION_JSON)
                .body(staff)
                .retrieve()
                .body(Staff.class);
    }

    public Staff update(Integer id, Staff staff){
        return restClient.put()
                .uri("/staff/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(staff)
                .retrieve()
                .body(Staff.class);
    }

    public void delete(Integer id){
        restClient.delete()
                .uri("/staff/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }



}
