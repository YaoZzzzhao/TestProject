package com.project.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
//@RefreshScope
public class ConfigController {
    @Value("${first.name}")
    private String firstName;

    @Value("${last.name}")
    private String lastName;

    @GetMapping(value = "test/{genDer}")
    public String show(@PathVariable String genDer){
        if( !genDer.equals("female")){
            return "Not Acceptable Gender for URL";
        }
        String s = "According to the config file, "+genDer+", "+firstName +", and the last name is "+lastName;
        return s;
    }

}
