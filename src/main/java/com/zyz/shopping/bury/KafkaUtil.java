package com.zyz.shopping.bury;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaUtil {

    private static final String BURY_TOPIC = "bury";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String content) {
        log.info("发送埋点数据" + content);
        kafkaTemplate.send(BURY_TOPIC, content);
    }
}
