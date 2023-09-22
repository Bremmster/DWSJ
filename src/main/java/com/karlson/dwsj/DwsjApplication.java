package com.karlson.dwsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DwsjApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwsjApplication.class, args);
    }
}
