package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

import java.time.LocalDate;
import java.util.stream.Stream;

class DemoControllerTest {

    @ParameterizedTest
    @MethodSource("clients")
    void mvcTest(WebTestClient client) {
        var res = client.get()
                .uri("/date")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody(LocalDate.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertThat(res).isNull();
    }

    public static Stream<WebTestClient> clients() {
        return Stream.of(MockMvcWebTestClient.bindToController(new DemoController())
                .configureClient()
                .build(), WebTestClient.bindToController(new DemoController())
                .configureClient()
                .build());
    }
}
