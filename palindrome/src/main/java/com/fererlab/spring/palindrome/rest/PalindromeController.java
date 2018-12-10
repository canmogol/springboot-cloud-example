package com.fererlab.spring.palindrome.rest;

import com.fererlab.spring.palindrome.service.PalindromeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Slf4j
@RestController
public class PalindromeController {

    @Autowired
    Tracer tracer;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PalindromeService palindromeService;

    @RequestMapping("/")
    public String salute() {
        tracer.addTag("PalindromeApplication.tag", "tag-value");
        Span span = tracer.getCurrentSpan();
        int nextInt = new Random().nextInt(100);
        span.setBaggageItem("this-is-an-integer-key", "and-the-value-is-" + nextInt);

        log.info("Inside Zipkin Service 2, controller");

        String response = restTemplate.exchange("http://localhost:8082/",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }).getBody();

        String reverse = palindromeService.revert(response);
        return String.format("%s%s", response, reverse);
    }

}

