package com.KNops.Authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.KNops.Authenticationservice.user")
public class AuthenticationServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthenticationServiceApplication.class, args);
    }

}
