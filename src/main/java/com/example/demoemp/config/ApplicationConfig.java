package com.example.demoemp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;

/**
 * @author bogdan.burnea
 */
@Configuration
@PropertySources({@PropertySource("classpath:application.properties")})
public class ApplicationConfig {

    // miscellaneous properties

    @Value("${application.name}")
    @NotBlank
    @Getter
    private String applicationName;

    @Value("${version.number}")
    @NotBlank
    @Getter
    private String versionNumber;

    @Value("${version.name}")
    @NotBlank
    @Getter
    private String versionName;
}