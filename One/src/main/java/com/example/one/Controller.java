package com.example.one;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@Slf4j
public class Controller {

    private final RestTemplate demoRestTemplate;

    public Controller(RestTemplate demoRestTemplate) {
        this.demoRestTemplate = demoRestTemplate;
    }

    @GetMapping("/demoPath1")
    public ResponseEntity demoPath1() {
        log.info("Request at {} for request /demoPath1 ", getClass());
        String url = "http://localhost:8082/api/v2";
        String requestResponse = demoRestTemplate.getForObject(url, String.class);
        return ResponseEntity.ok("response from /demoPath1 + " + requestResponse);
    }

}
