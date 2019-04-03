package com.zyz.shopping.bury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaUtil {

    private static final String BURY_TOPIC = "bury";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String content) {
        kafkaTemplate.send(BURY_TOPIC, content);
    }
}
