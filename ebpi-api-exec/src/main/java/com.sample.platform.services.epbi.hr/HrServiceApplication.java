package com.sample.platform.services.epbi.hr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class HrServiceApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(HrServiceApplication.class, args);
        System.out.println("......Hr Application started .........");
    }

}
