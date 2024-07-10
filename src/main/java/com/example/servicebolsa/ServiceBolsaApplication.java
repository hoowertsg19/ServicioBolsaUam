package com.example.servicebolsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.servicebolsa.repository")
public class ServiceBolsaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceBolsaApplication.class, args);
    }
}

