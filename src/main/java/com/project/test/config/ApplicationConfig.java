package com.project.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Value("${first.name}")
    private String firstName;

    @Value("${last.name}")
    private String lastName;

    void configTest(){
        String f = firstName;
        String l = lastName;
        System.out.println("According to the config file, the first name is "+firstName +", and the last name is "+lastName);
    }

    public static void main(String[] args) {
        ApplicationConfig ac = new ApplicationConfig();
        ac.configTest();
    }
}
