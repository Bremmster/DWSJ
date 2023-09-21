package com.karlson.dwsj.service;

import org.apache.kafka.common.protocol.types.Field;

public class RestClient {

    private String url = "http://localhost:8080/api/v1/kafka/publish";

    private String postData;

    public RestClient(String postData) {
        this.postData = postData;
    }

    
}
