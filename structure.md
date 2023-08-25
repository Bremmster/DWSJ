First plan of structure
Only one topic in kafka
```mermaid
stateDiagram-v2
    [*] --> webAPI
    webAPI --> Producer
    Producer --> Kafka
    Kafka --> KafkaConsumerA
    Kafka --> KafkaConsumerB
    KafkaConsumerA --> mySQL
    KafkaConsumerB --> app
```


