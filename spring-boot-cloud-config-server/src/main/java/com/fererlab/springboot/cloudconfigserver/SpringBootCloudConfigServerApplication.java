package com.fererlab.springboot.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Application Entry Point.
 */
@EnableConfigServer
@SpringBootApplication
public class SpringBootCloudConfigServerApplication {

    /**
     * Spring Boot main method.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(SpringBootCloudConfigServerApplication.class, args);
    }

}
