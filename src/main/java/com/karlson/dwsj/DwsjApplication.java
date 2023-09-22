package com.karlson.dwsj;

import com.karlson.dwsj.model.Pokemon;
import com.karlson.dwsj.service.RestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class DwsjApplication { // implements CommandLineRunner

    public static void main(String[] args) {
        SpringApplication.run(DwsjApplication.class, args);
    }
}
