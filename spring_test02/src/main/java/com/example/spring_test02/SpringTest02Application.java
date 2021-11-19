package com.example.spring_test02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringTest02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTest02Application.class, args);
    }

}
