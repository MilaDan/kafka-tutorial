package com.chuwa.kafkatutorial.kafka;

import com.chuwa.kafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author b1go
 * @date 7/14/22 10:18 PM
 */
@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "myGroup")
    public void consume(User data) {
        LOGGER.info(String.format("Message received -> %s", data.toString()));
    }
}
