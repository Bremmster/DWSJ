package com.karlson;


import com.karlson.application.Menu;
import com.karlson.kafka.KafkaConsumer;
import com.karlson.service.HttpClient;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        new Menu(new Random(), new HttpClient(), new KafkaConsumer());
    }
}