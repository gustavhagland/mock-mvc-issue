package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

import java.time.LocalDate;

class DemoControllerTest {

    @Test
    void mvcTest() {
        var client = MockMvcWebTestClient.bindToController(new DemoController())
                .configureClient()
                .build();

        var res = client.get()
                .uri("/date")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody(LocalDate.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertThat(res).isNull();
    }
}
