package com.karlson.dwsj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DwsjApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DwsjApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("""
                How to use:
                Start Kafka Zookeper with default config
                Start one or more kafka brokers on localhost ports 9093-9095, customized configs is located in kafkaConfigs
                Start a mysql server on port localhost:3306 make a Schema "pokedb"
                create "user" with "password" and give them privileges to the schema
                for testing create schema "testdb" and a user "test" password "test" with privileges to schema
                                
                Run module "Pokemon producer" to get the web api running att localhost:8080
                Run module "Pokemon-consume-SQL" to store all the Pokémons in the database
                The "User-client" is a client application with a console menu.
                It will find random pokémons and the user can give the pokemon a name and send it to the webAPI
                """);
    }
}
