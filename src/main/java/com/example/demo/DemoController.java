package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DemoController {

    @GetMapping(value = "date", produces = MediaType.APPLICATION_JSON_VALUE)
    public LocalDate date() {
        return null;
    }
}
