package com.fererlab.springboot.cloudconfigclient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration client properties.
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "label")
public class ConfigClientLabelProperties {

    private String first;
    private String second;

}
