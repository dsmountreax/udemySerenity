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
    @Value("https://www.google.com/")
    private String urlGoogle;

    @Getter
    @Value("${app.url.moodle}")
    private String urlMoodle;

    @Getter
    @Value("${app.username.moodle}")
    private String userNameMoodle;

    @Getter
    @Value("${app.password.moodle}")
    private String passwordMoodle;

    @Getter
    @Value("${app.url.calculator}")
    private String urlCalculator;

    @Getter
    @Value("10")
    private String firstValue;

    @Getter
    @Value("5")
    private String secondValue;

    @Getter
    @Value("${app.url.pos}")
    private String urlPos;

    @Getter
    @Value("${user.pos}")
    private String userPos;

    @Getter
    @Value("${password.pos}")
    private String passwordPos;


    public  String getUrlGoogle(){
        return urlGoogle;
    }

}
