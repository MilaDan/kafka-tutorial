package com.chuwa.kafkatutorial.controller;

import com.chuwa.kafkatutorial.kafka.KafkaProducer;
import com.chuwa.kafkatutorial.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author b1go
 * @date 7/14/22 10:08 PM
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class MeesageController {

    @Resource
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
