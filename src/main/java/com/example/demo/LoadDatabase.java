package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ClienteRepository repository) {
        return args -> {
            repository.save(new Cliente("Matias", "Araya"));
            repository.save(new Cliente("Nicolas", "Maturana"));
        };
    }
}
