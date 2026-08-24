package br.com.solsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SolSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolSystemApplication.class, args);
    }
}
