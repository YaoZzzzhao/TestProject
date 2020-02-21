package com.project.test.config;

//import jdk.jfr.DataAmount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class AppConfig {
    @Value("${first.name}")
    private String firstName;

    @Value("${last.name}")
    private String lastName;

//    void configTest(){
//        String f = firstName;
//        String l = lastName;
//        System.out.println("According to the config file, the first name is "+firstName +", and the last name is "+lastName);
//    }
//
//    public static void main(String[] args) {
//        AppConfig ac = new AppConfig();
//        ac.configTest();
//    }
}
