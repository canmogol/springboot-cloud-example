package com.fererlab.spring.salute;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SaluteApplication {

    @Autowired
    Tracer tracer;

    @RequestMapping("/")
    public String salute() {

        tracer.addTag("SaluteApplication.tag", "tag-value");
        Span span = tracer.getCurrentSpan();
        String baggageItem = span.getBaggageItem("this-is-an-integer-key");

        log.info("Inside Zipkin Service 1 ...");
        return "Hi There! " + baggageItem;
    }

    public static void main(String[] args) {
        SpringApplication.run(SaluteApplication.class, args);
    }
}


