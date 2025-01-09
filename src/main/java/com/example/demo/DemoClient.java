package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

public class DemoClient {

    public static void main(String[] args) {
        var client = RestClient.create("http://localhost:8080");

        System.out.println(client.get()
                .uri("date")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(LocalDate.class));

        var reactiveClient = WebClient.create("http://localhost:8080");

        System.out.println(reactiveClient.get()
                .uri("date")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(LocalDate.class)
                .block());
    }
}
