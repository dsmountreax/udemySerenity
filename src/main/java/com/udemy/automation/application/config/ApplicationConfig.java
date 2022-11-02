package com.udemy.automation.application.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Henry J. Calani A.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {


    @Getter
    @Value("${app.url.moodle}")
    private String urlMoodle;

    @Getter
    @Value("${app.username.moodle}")
    private String userNameMoodle;

    @Getter
    @Value("${app.password.moodle}")
    private String passwordMoodle;

}
