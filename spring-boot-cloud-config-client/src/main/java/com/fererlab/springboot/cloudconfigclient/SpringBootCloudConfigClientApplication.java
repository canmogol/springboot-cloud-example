package com.fererlab.springboot.cloudconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot Cloud Config Client.
 */
@RestController
@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootCloudConfigClientApplication {

    @Autowired
    private ConfigClientLabelProperties properties;

    /**
     * Spring Boot application entry point.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(SpringBootCloudConfigClientApplication.class, args);
    }

    /**
     * Returns default label.
     *
     * @return default label
     */
    @GetMapping(value = "/labels/default")
    public final String label() {
        return String.format("%s, %s", properties.getFirst(), properties.getSecond());
    }

}


